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
import entidad.Materia;
import entidad.Nacionalidad;
import entidad.Provincia;
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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getSession().getAttribute("user") == null || !request.getSession().getAttribute("rol").toString().equals("1"))
		{
			request.getRequestDispatcher("inicio").forward(request, response);
			return;
		}
		
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
		String str = request.getParameter("alumnos").toString().substring(1);
		//String[] legajos = str.split("\\|");		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		System.out.print(str);
		/*for(String legajo : legajos)
		{
			Alumno alumno = new AlumnoNegocio().buscarAlumno(Integer.parseInt(legajo));
			alumnos.add(alumno);
		}
		**/
		try
		{
			Curso curso = new Curso();
			curso.setIdMateria(Integer.parseInt(request.getParameter("materia").toString()));
			curso.setProfesor(Integer.parseInt(request.getParameter("docente").toString()));
			curso.setListAlu(alumnos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
