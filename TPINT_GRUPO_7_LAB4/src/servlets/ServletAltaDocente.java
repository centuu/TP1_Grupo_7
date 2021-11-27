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
import entidad.Docente;
import entidad.Localidad;
import entidad.Nacionalidad;
import negocio.DocenteNegocio;
import negocio.LocalidadNegocio;
import negocio.NacionalidadNegocio;

@WebServlet(name = "ServletAltaDocente", urlPatterns = { "/altadocente" })
public class ServletAltaDocente extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
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
		request.setAttribute("nextLegajo", new DocenteNegocio().GetNextLegajo());
		
		request.getRequestDispatcher("/AltaDocente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("btnregistrar") != null)
		{
			Docente docente= new Docente();
			docente.setDni(request.getParameter("txtdni"));
			docente.setNombre(request.getParameter("txtnombre"));
			docente.setApellido(request.getParameter("txtapellido"));
			docente.setFechaNac(request.getParameter("txtfechanac"));
			docente.setDireccion(request.getParameter("txtdireccion"));
			docente.setLocalidad(request.getParameter("Localidad").toString());
			docente.setNacionalidad(request.getParameter("nacionalidad").toString());
			docente.setMail(request.getParameter("txtmail"));
			docente.setTelefono(request.getParameter("txttelefono"));
			docente.setClave(request.getParameter("txtclave"));
			docente.setestado(true);
			
    		new DocenteNegocio().insert(docente);
		}
		
		doGet(request, response);
	}

}
