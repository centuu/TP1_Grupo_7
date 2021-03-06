package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Curso;
import negocio.CursadaNegocio;
import negocio.CursoNegocio;

@WebServlet(name = "ServletCargarNotas", urlPatterns = { "/notas" })
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
		
		int idcurso= Integer.parseInt(request.getParameter("IdCurso").toString());
		ArrayList <Alumno> listacursada = new CursadaNegocio().Alumnos_X_Docente(idcurso);
		request.setAttribute("listaCursada",listacursada);
		
		request.getRequestDispatcher("/CargarNotas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idCurso = Integer.parseInt(request.getParameter("idCurso").toString());
		ArrayList <Alumno> listacursada = new CursadaNegocio().Alumnos_X_Docente(idCurso);
		for(int i = 0 ; i<listacursada.size(); i++ )
		{
			listacursada.get(i).setIdCurso(idCurso);
			listacursada.get(i).setNota_pri(Float.parseFloat(request.getParameter("nota1_"+i).toString()));
			listacursada.get(i).setNota_seg(Float.parseFloat(request.getParameter("nota2_"+i).toString()));
			listacursada.get(i).setRec_pri(Float.parseFloat(request.getParameter("rec1_"+i).toString()));
			listacursada.get(i).setRec_seg(Float.parseFloat(request.getParameter("rec2_"+i).toString()));
			listacursada.get(i).setCondicion((request.getParameter("condicion_"+i).toString()));
		}
		CursadaNegocio cursadanegocio = new CursadaNegocio();
		if(cursadanegocio.update(idCurso, listacursada))
		{
			request.setAttribute("messageSuccess", "Se modificaron las notas del curso con exito.");
		}
		else
		{
			request.setAttribute("messageError", "Hubo un problema al actualizar el curso.");
		}
		request.getRequestDispatcher("/vistaDocente?page=1").forward(request, response);
	}
}