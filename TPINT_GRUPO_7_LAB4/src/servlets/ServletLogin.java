package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;


@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
        
    }

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginDao dao = new LoginDao();
		
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("password");
		
			try {
				if (dao.check(usuario, clave))
				{
					response.sendRedirect("AltaAlumno.jsp");
				}
				else
				{
					response.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		
	}

}
