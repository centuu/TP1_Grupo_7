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
public class ServletSeguro extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ServletSeguro() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("btnAceptar")!=null)
		{
			   Seguro ser= new Seguro();
			   
			   //ser.setIdSeguro();
			   ser.setDescripcion(request.getParameter("txtDesc"));
			   ser.setCostoContratacion( Integer.parseInt(request.getParameter("txtCostCon")));
			   ser.setCostoMaximo(Integer.parseInt( request.getParameter("txtCostMax")));
			   ser.setTipo(Integer.parseInt( request.getParameter("tiposeguro")));
			   SeguroDao dao=new  SeguroImpl();
			   dao.insert(ser);
		}
		
		RequestDispatcher rd=  request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request,response);
   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
