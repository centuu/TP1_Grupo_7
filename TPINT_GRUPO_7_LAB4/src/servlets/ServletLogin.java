package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import entidad.Usuario;


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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("password");
		
		UsuarioDao userDao = new UsuarioDao();
        
        try {
            Usuario user = userDao.checkLogin(usuario, clave);
            String destPage = "login.jsp";
             
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "AltaAlumno.jsp";
            } else {
                String message = "Usuario o contraseņa incorrecta.";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
