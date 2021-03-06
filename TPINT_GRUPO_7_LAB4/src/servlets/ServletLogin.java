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
import daoImpl.UsuarioDaoImpl;
import entidad.Docente;
import entidad.Usuario;
import negocio.DocenteNegocio;
import negocio.UsuarioNegocio;


@WebServlet(name = "ServletLogin", urlPatterns = { "/login" })
public class ServletLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession().invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("password");
        
        try 
        {
            Usuario user = new UsuarioNegocio().checkLogin(usuario, clave);
            
            String destPage = "login.jsp";
             
            if (user != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                int legajo = user.getLegajo();
                if (legajo == 0)
                {
                	session.setAttribute("name", user.getUsuario());
                }
                else 
                {
                	Docente doc = new DocenteNegocio().buscarDocente(legajo);
                	session.setAttribute("name", doc.getNombre() + " " + doc.getApellido());
                }
                
                session.setAttribute("rol", user.getRol());
                destPage = "inicio.jsp";
            } 
            else
            {
                String message = "Usuario o contrase?a incorrecta.";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);  
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
            throw new ServletException(ex);
        }
	}
}
