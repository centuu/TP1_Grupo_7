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
			Alumno alu=new Alumno();
    		alu.setDni(Integer.parseInt(request.getParameter("txtdni")));
    		alu.setNombre(request.getParameter("txtnombre"));
    		alu.setApellido(request.getParameter("txtapellido"));
    		alu.setDireccion(request.getParameter("txtdireccion"));
    		alu.setProvincia(request.getParameter("txtprovincia"));
    		alu.setNacionalidad(Integer.parseInt(request.getParameter("nacionalidad")));
    		alu.setMail(request.getParameter("txtmail"));
    		alu.setTelefono(Integer.parseInt(request.getParameter("txttelefono")));

    		AlumnoImpl dao=new AlumnoImpl();
    		dao.insert(alu);
    		
    		 RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.jsp");
             dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}
}
