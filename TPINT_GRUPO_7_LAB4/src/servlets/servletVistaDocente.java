package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Curso;
import entidad.Docente;
import entidad.Usuario;
import negocio.AlumnoNegocio;
import negocio.CursadaNegocio;
import negocio.CursoNegocio;

@WebServlet(name = "servletVistaDocente", urlPatterns = { "/vistaDocente" })
public class servletVistaDocente extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public servletVistaDocente() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int rol=(int)request.getSession().getAttribute("rol");
		
		if(request.getSession().getAttribute("user") == null )
		{
			request.getRequestDispatcher("inicio").forward(request, response);
			return;
		}
		if (request.getParameter("btnnuevo")!=null)
		{		
			request.getRequestDispatcher("/altacurso").forward(request, response);
			return;
		}
		
		if(request.getParameter("alumnos") != null)
		{
			
			
			request.getRequestDispatcher("/notas").forward(request, response);
			return;
		}
		
		int pageid = Integer.parseInt(request.getParameter("page"));  
		int total = 5;
		int noOfRecords;
		ArrayList<Curso> listaCursos;
		
		if(request.getSession().getAttribute("user") != null) 
		{ 
			if (rol==2)
			{
				Usuario user= (Usuario)request.getSession().getAttribute("user");
				
				listaCursos = new CursoNegocio().listar_X_Docente(user.getLegajo(), pageid, total);
				noOfRecords =  new CursoNegocio().cantRegistros(user.getLegajo());
					
				
			}
			else {
				listaCursos = new CursoNegocio().list(pageid, total);
				noOfRecords =  new CursoNegocio().cantRegistros();
					
				
			}
			
			
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / total);
	        
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", pageid);
	        request.setAttribute("listaCurso", listaCursos);	
	        request.getRequestDispatcher("/VistaDocente.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
