package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoImpl;
import entidad.Alumno;

@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ServletAlumno() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("btnregistrar") != null)
		{
			Alumno alumno = new Alumno();
			alumno.setDni(request.getParameter("txtdni"));
			alumno.setNombre(request.getParameter("txtnombre"));
			alumno.setApellido(request.getParameter("txtapellido"));
			alumno.setFechaNac(request.getParameter("txtfechanac"));
			alumno.setDireccion(request.getParameter("txtdireccion"));
			alumno.setProvincia(request.getParameter("provincia").toString());
			alumno.setNacionalidad(request.getParameter("nacionalidad").toString());
			alumno.setMail(request.getParameter("txtmail"));
			alumno.setTelefono(request.getParameter("txttelefono"));
			alumno.setestado(true);

    		AlumnoImpl dao=new AlumnoImpl();
    		dao.insert(alumno);
    		
    		 RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.jsp");
             dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}
}
