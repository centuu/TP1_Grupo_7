package servlets;

import java.io.IOException;
import java.sql.SQLException;
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
	private boolean editar;
       
    public ServletAlumno() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{				
		if(request.getSession().getAttribute("user") == null || !request.getSession().getAttribute("rol").toString().equals("1"))
		{
			request.getRequestDispatcher("inicio").forward(request, response);
			return;
		}
		
		if(request.getParameter("legajo") != null)
		{
			editar = true;
			int legajo= Integer.parseInt(request.getParameter("legajo").toString());
			Alumno alumno = new AlumnoNegocio().buscarAlumno(legajo);			
			
			if (request.getParameter("btninfo")!=null)
			{
				request.setAttribute("readOnly" , "readOnly");
				request.setAttribute("alumno", alumno);
				request.setAttribute("nacionalidad", alumno.getNacionalidad().getId());
				request.setAttribute("provincia", alumno.getProvincia().getId());
				request.getRequestDispatcher("/UpdateAlumno.jsp").forward(request, response);
				
			}
			else if (request.getParameter("btneditar")!=null)
			{		
				request.setAttribute("readOnly" , "");
				request.setAttribute("alumno", alumno);
				request.setAttribute("nacionalidad", alumno.getNacionalidad().getId());
				request.setAttribute("provincia", alumno.getProvincia().getId());
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
			editar = false;
			request.setAttribute("nextLegajo", new AlumnoNegocio().GetNextLegajo());
			ArrayList<Provincia> listaProvincias = new ProvinciaNegocio().list();		
			ArrayList<Nacionalidad> listaNacionalidad = new NacionalidadNegocio().list();

			request.setAttribute("provincias", listaProvincias);
			request.setAttribute("nacionalidades", listaNacionalidad);
			request.getRequestDispatcher("/AltaAlumno.jsp").forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (editar)
		{
			//Alumno alumno = new Alumno();
			int legajo= Integer.parseInt(request.getParameter("txtLegajo").toString());
			Alumno alumno = new AlumnoNegocio().buscarAlumno(legajo);
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
			//alumno.setestado(true);
			
			new AlumnoNegocio().update(alumno);
			
			request.setAttribute("messageSuccess", "Se modifico el alumno con exito.");
			request.getRequestDispatcher("/listaralumnos?page=1").forward(request, response);
			
		}
		else
		{
			try
			{
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
				
				request.setAttribute("messageSuccess", "Se cargo el alumno con exito.");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				if (e.getMessage().contains("unq_DNI"))
				{
					request.setAttribute("messageError", "El DNI ya existe en la base de datos.");
				}
			}
			//doGet(request, response);
			request.getRequestDispatcher("/inicio.jsp").forward(request, response);
		}
	}
}
