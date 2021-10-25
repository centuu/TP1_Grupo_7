package servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeguroDao;
import daoImpl.SeguroImpl;
import entidad.Seguro;

@WebServlet("/ServletSeguro")
public class ServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnFiltrar")!=null)
		   {
		    //List <datos> listData = 
		    //request.setAttribute("listData", listData);
		    RequestDispatcher rd = getServletContext()
		                               .getRequestDispatcher("/path/to/page.jsp");
		    rd.forward(request, response);
		   }
		
		RequestDispatcher rd=  request.getRequestDispatcher("/ListarSeguros.jsp");
		rd.forward(request,response);
   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
