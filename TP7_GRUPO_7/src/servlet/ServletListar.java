package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.SeguroDao;
import daoImpl.SeguroImpl;
import entidad.Seguro;

@WebServlet("/ServletListar")
public class ServletListar extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    public ServletListar() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("btnFiltrar") != null)
		{
              SeguroImpl serg =new  SeguroImpl(); 
              ArrayList<Seguro> lista= new ArrayList<Seguro>();
              lista=serg.listarxTipo(request.getParameter("tiposeguro"));// le mando el tipoSeguro como parametro para buscar la lista por tipo de seguro
              request.setAttribute("listSeguros", lista);
              
		}
		
		RequestDispatcher rd=  request.getRequestDispatcher("/ListarSeguros.jsp");
		
		rd.forward(request,response);
   }
}

