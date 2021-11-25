package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Docente;
import entidad.Materia;
import negocio.AlumnoNegocio;
import negocio.DocenteNegocio;
import negocio.MateriaNegocio;

@WebServlet(name = "ServletAltaCurso", urlPatterns = { "/altacurso" })
public class ServletAltaCurso extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ServletAltaCurso() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Alumno> listaAlumnos = new AlumnoNegocio().list();
		ArrayList<Docente> listaDocentes = new DocenteNegocio().list();
		ArrayList<Materia> listaMateria = new MateriaNegocio().list();
		
		request.setAttribute("docentes", listaDocentes);
		request.setAttribute("alumnos", listaAlumnos);
		request.setAttribute("materias", listaMateria);
		request.getRequestDispatcher("/AltaCurso.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
