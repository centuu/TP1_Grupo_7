package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.DocenteImpl;
import daoImpl.LocalidadDaoImpl;
import daoImpl.NacionalidadDaoImpl;
import entidad.Alumno;
import entidad.Docente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import negocio.AlumnoNegocio;
import negocio.DocenteNegocio;
import negocio.LocalidadNegocio;
import negocio.NacionalidadNegocio;
import negocio.ProvinciaNegocio;
import negocio.UsuarioNegocio;

@WebServlet(name = "ServletAltaDocente", urlPatterns = { "/altadocente" })
public class ServletAltaDocente extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private boolean editar;
 
    public ServletAltaDocente() 
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
		
		ArrayList<Localidad> listaLocalidades = new LocalidadNegocio().list();
		ArrayList<Nacionalidad> listaNacionalidad = new NacionalidadNegocio().list();
		request.setAttribute("localidades", listaLocalidades);
		request.setAttribute("nacionalidades", listaNacionalidad);
		
		if(request.getParameter("legajo") != null)
		{
			editar = true;
			int legajo= Integer.parseInt(request.getParameter("legajo").toString());
			Docente docente = new DocenteNegocio().buscarDocente(legajo);			
			
			if (request.getParameter("btninfo")!=null)
			{
				request.setAttribute("readOnly" , "readOnly");
				request.setAttribute("docente", docente);
				request.setAttribute("nacionalidad", docente.getNacionalidad().getId());
				request.setAttribute("localidad", docente.getLocalidad().getId());
				request.getRequestDispatcher("/UpdateDocente.jsp").forward(request, response);			
			}
			else if (request.getParameter("btneditar")!=null)
			{		
				request.setAttribute("readOnly" , "");
				request.setAttribute("docente", docente);
				request.setAttribute("nacionalidad", docente.getNacionalidad().getId());
				request.setAttribute("localidad", docente.getLocalidad().getId());
				request.getRequestDispatcher("/UpdateDocente.jsp").forward(request, response);			
			}
			else if (request.getParameter("btneliminar")!=null)
			{		
				int id = Integer.parseInt(request.getParameter("legajo"));	        
				new DocenteNegocio().delete(id);		
				request.getRequestDispatcher("/Docentes.jsp").forward(request, response);
			}
			else if (request.getParameter("btnnuevo")!=null)
			{		
				request.getRequestDispatcher("/altadocente").forward(request, response);
				
			}
		}
		else
		{
			editar = false;
			
			request.setAttribute("nextLegajo", new DocenteNegocio().GetNextLegajo());
			
			request.getRequestDispatcher("/AltaDocente.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (!editar)
		{
			try
			{
				Docente docente= new Docente();
				docente.setDni(request.getParameter("txtdni"));
				docente.setNombre(request.getParameter("txtnombre"));
				docente.setApellido(request.getParameter("txtapellido"));
				docente.setFechaNac(request.getParameter("txtfechanac"));
				docente.setDireccion(request.getParameter("txtdireccion"));
				
				Localidad local = new Localidad();
				local.setId(Integer.parseInt(request.getParameter("Localidad")));	
				docente.setLocalidad(local);
				
				Nacionalidad nacion= new Nacionalidad();
				nacion.setId(Integer.parseInt(request.getParameter("nacionalidad")));
				docente.setNacionalidad(nacion);
				
				docente.setMail(request.getParameter("txtmail"));
				docente.setTelefono(request.getParameter("txttelefono"));
				docente.setClave(request.getParameter("txtclave"));
				docente.setestado(true);
				
				new DocenteNegocio().insert(docente);
				//new UsuarioNegocio().insert(docente);
				
				request.setAttribute("messageSuccess", "Se cargo el docente con exito.");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				if (e.getMessage().contains("unq_docenteDNI"))
				{
					request.setAttribute("messageError", "El DNI ya existe en la base de datos.");
				}
			}
			request.getRequestDispatcher("/inicio.jsp").forward(request, response);
		}
		else 
		{
			//Docente docente= new Docente();
			int legajo= Integer.parseInt(request.getParameter("txtLegajo").toString());
			Docente docente = new DocenteNegocio().buscarDocente(legajo);
			
			docente.setDni(request.getParameter("txtdni"));
			docente.setNombre(request.getParameter("txtnombre"));
			docente.setApellido(request.getParameter("txtapellido"));
			docente.setFechaNac(request.getParameter("txtfechanac"));
			docente.setDireccion(request.getParameter("txtdireccion"));
			
			Localidad local = new Localidad();
			local.setId(Integer.parseInt(request.getParameter("Localidad")));	
			docente.setLocalidad(local);
			
			Nacionalidad nacion= new Nacionalidad();
			nacion.setId(Integer.parseInt(request.getParameter("nacionalidad")));
			docente.setNacionalidad(nacion);
			
			docente.setMail(request.getParameter("txtmail"));
			docente.setTelefono(request.getParameter("txttelefono"));
			
			//docente.setClave(request.getParameter("txtclave"));
			//docente.setestado(true);
			
			new DocenteNegocio().update(docente);
			
			request.setAttribute("messageSuccess", "Se modifico el docente con exito.");
			request.getRequestDispatcher("/listardocentes?page=1").forward(request, response);
		}
		
		//doGet(request, response);
	}

}
