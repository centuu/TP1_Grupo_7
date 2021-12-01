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
import entidad.Usuario;
import negocio.CursadaNegosio;
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
			Usuario user= (Usuario)request.getSession().getAttribute("user");
			
			ArrayList<Curso> listaCursos = new CursoNegocio().listar_X_Docente(user.getLegajo());
			request.setAttribute("listaCurso", listaCursos);		
			request.getRequestDispatcher("/VistaDocente.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("alumnos") != null)
		{
			int idcurso= Integer.parseInt(request.getParameter("IdCurso").toString());
			String cursodescripcion=request.getParameter("cursodes").toString();
			ArrayList<Alumno> listacursada = new CursadaNegosio().Alumnos_X_Docente(idcurso);	
			// Curso  curso= new CursoNegocio().BuscarCurso(idcurso);
			//request.setAttribute("curso",curso);
			request.setAttribute("curso",cursodescripcion);
			request.setAttribute("listaCursada",listacursada);
			request.getRequestDispatcher("/CargarNotas.jsp").forward(request, response);	
		}
		doGet(request, response);
	}

}
