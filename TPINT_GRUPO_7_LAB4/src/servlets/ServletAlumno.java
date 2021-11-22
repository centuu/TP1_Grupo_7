package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoImpl;
import daoImpl.NacionalidadDaoImpl;
import daoImpl.ProvinciaDaoImpl;
import entidad.Alumno;
import entidad.Nacionalidad;
import entidad.Provincia;
import negosioImpl.AlumnoNegosioImpl;
import negosioImpl.NacionalidadNegosioImpl;

@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	AlumnoNegosioImpl aluNeg=new AlumnoNegosioImpl();
    public ServletAlumno() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int legajo;
		Alumno alum =new Alumno();
		
		if (request.getParameter("btninfo")!=null)//si viene a ver la info drl alumno
		{
			legajo= Integer.parseInt(request.getParameter("legajo").toString());
			alum=aluNeg.buscarAlumno(legajo);			
			request.setAttribute("alumno", alum);
			request.getRequestDispatcher("/UpdateAlumno.jsp").forward(request, response);			
		}
		else if (request.getParameter("btneditar")!=null)
		{		
			legajo= Integer.parseInt(request.getParameter("legajo").toString());
			alum=aluNeg.buscarAlumno(legajo);			
			request.setAttribute("alumnoeditar", alum);
			request.getRequestDispatcher("/UpdateAlumno.jsp").forward(request, response);			
		}
		else if (request.getParameter("btneliminar")!=null)
		{		
			legajo= Integer.parseInt(request.getParameter("legajo").toString());
			aluNeg.eliminar(legajo);			
			request.getRequestDispatcher("/ServletListarAlumnos").forward(request, response);			
		}
		else
		{
			request.setAttribute("nextLegajo", aluNeg.GetNextLegajo());
			ArrayList<Provincia> listaProvincias =new NacionalidadNegosioImpl().listProvincia();
			ArrayList<Nacionalidad> listaNacionalidad = new NacionalidadNegosioImpl().listNacion();
			request.setAttribute("provincias", listaProvincias);
			request.setAttribute("nacionalidades", listaNacionalidad);
			request.getRequestDispatcher("/AltaAlumno.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String registrar=request.getParameter("btnregistrar");
		String guardar=request.getParameter("btnguardar");
		Alumno alumno = new Alumno();
		if(registrar!=null||guardar!= null)
		{
			alumno = new Alumno();
			
			alumno.setDni(request.getParameter("txtdni"));
			alumno.setNombre(request.getParameter("txtnombre"));
			alumno.setApellido(request.getParameter("txtapellido"));
			alumno.setFechaNac(request.getParameter("txtfechanac"));
			alumno.setDireccion(request.getParameter("txtdireccion"));
			
			Provincia provi= new Provincia();
			provi.setId(Integer.parseInt(request.getParameter("provincia")));	
			alumno.setProvincia(provi);
			
			Nacionalidad nacion= new Nacionalidad();
			nacion.setId(Integer.parseInt(request.getParameter("nacionalidad")));
			alumno.setNacionalidad(nacion);
			
			alumno.setMail(request.getParameter("txtmail"));
			alumno.setTelefono(request.getParameter("txttelefono"));
			alumno.setestado(true);
		}
		
		if (registrar!=null)
		{
			aluNeg.insertar(alumno);
		}
		if (guardar!=null)
		{
			alumno.setNroLegajo(Integer.parseInt(request.getParameter("txtLegajo")));
		    aluNeg.editar(alumno);
			request.getRequestDispatcher("inicio.jsp").forward(request, response);
		}
		
		doGet(request, response);
	}
}
