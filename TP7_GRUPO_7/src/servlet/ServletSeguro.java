package servlet;

import java.io.IOException;
import java.math.BigDecimal;

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
		boolean isInvalid= false;
		if (request.getParameter("btnAceptar")!=null)
		{
			   Seguro ser= new Seguro();
			   String descripcion = request.getParameter("txtDesc");
			   String costoContratacion = request.getParameter("txtCostCon");
			   String costoMaximo = request.getParameter("txtCostMax");
			   String tipoSeguro = request.getParameter("tiposeguro");
			    
			   if(descripcion.isEmpty() || costoContratacion.isEmpty() || costoMaximo.isEmpty() || tipoSeguro.isEmpty())
			   {
				  isInvalid = true;			   
			   }
			   else
			   {
				   
				   if(isNumeric(request.getParameter("txtCostCon")))
				   {
					   ser.setCostoContratacion(new BigDecimal(request.getParameter("txtCostCon")));			   
				   }
				   else 
				   {
					   isInvalid = true;
				   }
				   
				   if(isNumeric(request.getParameter("txtCostCon")))
				   {
					   ser.setcostoAsegurado(new BigDecimal(request.getParameter("txtCostMax")));			   
				   }
				   else 
				   {
					   isInvalid = true;
				   }
				   ser.setDescripcion(request.getParameter("txtDesc"));
				   ser.setTipo(Integer.parseInt( request.getParameter("tiposeguro")));
			   }
			   SeguroDao dao=new  SeguroImpl();
			   
			   if(!isInvalid)
			   {
				   dao.insert(ser);				   
			   }
		}
		
		if(isInvalid == false)
		{
			System.out.println("flag false. No hubo problemas con validación de datos");
			RequestDispatcher rd=request.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(request,response);			
		}
		else
		{
			System.out.println("flag true. Hubo problemas con validación de datos");
			RequestDispatcher rd=request.getRequestDispatcher("/Inicio.jsp");
			rd.forward(request,response);
		}
   }

	private boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}		
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
