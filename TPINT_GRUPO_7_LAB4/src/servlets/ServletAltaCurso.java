package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoImpl;
import entidad.Alumno;

@WebServlet("/ServletAltaCurso")
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
		AlumnoImpl alumnoDAO = new AlumnoImpl();
		ArrayList<Alumno> list = alumnoDAO.list();
		request.setAttribute("alumnos", list);
		System.out.print(list);
		request.getRequestDispatcher("/AltaCurso.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
