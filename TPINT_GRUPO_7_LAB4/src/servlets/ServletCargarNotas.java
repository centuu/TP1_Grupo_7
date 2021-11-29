package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Curso;
import negocio.CursoNegocio;

@WebServlet(name = "ServletCargarNotas", urlPatterns = { "/CargarNotas" })
public class ServletCargarNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCargarNotas() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getSession().getAttribute("user") == null)
		{
			request.getRequestDispatcher("inicio").forward(request, response);
			return;
		}

		ArrayList<Curso> listaCursos = new CursoNegocio().list();

		request.setAttribute("cursos", listaCursos);

		request.getRequestDispatcher("/CargarNotas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
