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

		ArrayList<Curso> listaCursos = new CursoNegocio().list();

		request.setAttribute("cursos", listaCursos);
		
		request.getRequestDispatcher("/CargarNotas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList <Alumno> listacursada = new CursadaNegocio().Alumnos_X_Docente(Integer.parseInt(request.getParameter("idCurso").toString()));
		for(Alumno alumno : listacursada)
		{
			alumno.setIdCurso(Integer.parseInt(request.getParameter("idCurso").toString()));
			alumno.setNota_pri(Float.parseFloat(request.getParameter("nota1").toString()));
			alumno.setNota_seg(Float.parseFloat(request.getParameter("nota2").toString()));
			alumno.setRec_pri(Float.parseFloat(request.getParameter("rec1").toString()));
			alumno.setRec_seg(Float.parseFloat(request.getParameter("rec2").toString()));
			alumno.setCondicion((request.getParameter("condicion").toString()));
			new CursadaNegocio().update(alumno.getIdCurso(), alumno.getLegajo(), listacursada);
		}
		request.getRequestDispatcher("/inicio.jsp").forward(request, response);
		//doGet(request, response);
	}
}
