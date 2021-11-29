package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Curso;
import negocio.CursoNegocio;

@WebServlet(name = "servletVistaDocente", urlPatterns = { "/vistaDocente" })
public class servletVistaDocente extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public servletVistaDocente() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int rol=(int)request.getSession().getAttribute("rol");
		
		if(request.getSession().getAttribute("user") == null )
		{
			request.getRequestDispatcher("inicio").forward(request, response);
			return;
		}
		if(request.getSession().getAttribute("user") != null && rol==2)
		{
			int legajo=1;
			ArrayList<Curso> listaCursos = new CursoNegocio().listar_X_Docente(legajo);
			request.setAttribute("listaCurso", listaCursos);		
			request.getRequestDispatcher("/VistaDocente.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
