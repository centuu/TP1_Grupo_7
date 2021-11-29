package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Curso;
import negocio.AlumnoNegocio;
import negocio.CursoNegocio;

@WebServlet(name = "ServletListarAlumnos", urlPatterns = { "/listaralumnos" })
public class ServletListarAlumnos extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ServletListarAlumnos() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getSession().getAttribute("user") == null)
		{
			request.getRequestDispatcher("inicio").forward(request, response);
			return;
		}
		
		int pageid = Integer.parseInt(request.getParameter("page"));  
		int total = 5;
		
		ArrayList<Alumno> listaAlumnos = new AlumnoNegocio().list(pageid, total);		
		ArrayList<Curso> listaCursos = new CursoNegocio().list();
		
		int noOfRecords =  new AlumnoNegocio().cantRegistros();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / total);
        
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", pageid);
        
		request.setAttribute("cursos", listaCursos);		
		request.setAttribute("alumnos", listaAlumnos);
		request.getRequestDispatcher("/Alumnos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}