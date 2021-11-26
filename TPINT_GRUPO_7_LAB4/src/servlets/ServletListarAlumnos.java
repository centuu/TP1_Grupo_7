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
		ArrayList<Alumno> listaAlumnos = new AlumnoNegocio().list();
		ArrayList<Curso> listaCursos = new CursoNegocio().list();
		
		request.setAttribute("cursos", listaCursos);		
		request.setAttribute("alumnos", listaAlumnos);
		request.getRequestDispatcher("/Alumnos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("btneliminar") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
	        
			new AlumnoNegocio().delete(id);
		}
		
		doGet(request, response);
	}
}