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
import daoImpl.DocenteImpl;
import daoImpl.NacionalidadDaoImpl;
import daoImpl.ProvinciaDaoImpl;
import entidad.Alumno;
import entidad.Docente;
import entidad.Nacionalidad;
import entidad.Provincia;
import negocio.AlumnoNegocio;
import negocio.DocenteNegocio;

@WebServlet(name = "ServletListarDocentes", urlPatterns = { "/listardocentes" })
public class ServletListarDocentes extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ServletListarDocentes() 
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
		
		int pageid = Integer.parseInt(request.getParameter("page"));  
		int total = 5;  
		/*if (pageid == 1) {
		}  
		else {  
		    pageid = pageid-1;  
		    pageid = pageid*total+1;  
		}*/ 
		
		ArrayList<Docente> listaDocentes = new DocenteNegocio().list(pageid, total);
		
		int noOfRecords =  new DocenteNegocio().cantRegistros();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / total);
        
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", pageid);
		
		request.setAttribute("docentes", listaDocentes);
		request.getRequestDispatcher("/Docentes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("btneliminar") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
	        
			new DocenteNegocio().delete(id);
		}
		
		doGet(request, response);
	}
}