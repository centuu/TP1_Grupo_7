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
import negosioImpl.AlumnoNegosioImpl;

@WebServlet("/ServletListarAlumnos")
public class ServletListarAlumnos extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	AlumnoNegosioImpl aluNeg=new AlumnoNegosioImpl();
    public ServletListarAlumnos() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos=aluNeg.listar();
		request.setAttribute("alumnos", listaAlumnos);
		request.getRequestDispatcher("/Alumnos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("btneliminar") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
	        aluNeg.eliminar(id);
		}
		
		doGet(request, response);
	}
}