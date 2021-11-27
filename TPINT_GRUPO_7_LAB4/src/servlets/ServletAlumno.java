package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Nacionalidad;
import entidad.Provincia;
import negocio.AlumnoNegocio;
import negocio.NacionalidadNegocio;
import negocio.ProvinciaNegocio;

@WebServlet(name = "ServletAlumno", urlPatterns = { "/alumno" })
public class ServletAlumno extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ServletAlumno() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{				
		if(request.getParameter("legajo") != null)
		{
			int legajo= Integer.parseInt(request.getParameter("legajo").toString());
			Alumno alumno = new AlumnoNegocio().buscarAlumno(legajo);			
			
			if (request.getParameter("btninfo")!=null)
			{
				request.setAttribute("readOnly" , "readOnly");
				request.setAttribute("alumno", alumno);
				request.getRequestDispatcher("/UpdateAlumno.jsp").forward(request, response);			
			}
			else if (request.getParameter("btneditar")!=null)
			{		
				request.setAttribute("readOnly" , "");
				request.setAttribute("alumno", alumno);
				request.getRequestDispatcher("/UpdateAlumno.jsp").forward(request, response);			
			}
			else if (request.getParameter("btneliminar")!=null)
			{		
				int id = Integer.parseInt(request.getParameter("legajo"));	        
				new AlumnoNegocio().delete(id);		
				request.getRequestDispatcher("/Alumnos.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("nextLegajo", new AlumnoNegocio().GetNextLegajo());
			ArrayList<Provincia> listaProvincias = new ProvinciaNegocio().list();		
			ArrayList<Nacionalidad> listaNacionalidad = new NacionalidadNegocio().list();

			request.setAttribute("provincias", listaProvincias);
			request.setAttribute("nacionalidades", listaNacionalidad);
			request.getRequestDispatcher("/alumno.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//No creo necesaria la siguiente validacion, el formulario ya entra como invalido
		//if(request.getParameter("txtdni") != "" && request.getParameter("txtnombre") != "" && request.getParameter("txtapellido") != "" && request.getParameter("txtfechanac") != "" && request.getParameter("txtdireccion") != "" && request.getParameter("txtmail") != "" && request.getParameter("txttelefono") != "") 
		Alumno alumno = new Alumno();
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

		new AlumnoNegocio().insert(alumno);
	
		doGet(request, response);
	}
}
