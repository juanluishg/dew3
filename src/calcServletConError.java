import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcServlet
 */
@WebServlet(urlPatterns="/calculatorErr")
public class calcServletConError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcServletConError() {
        super();
        // TODO Auto-generated constructor stub
    }

    private double operacion (char op, double num1, double num2)
	{
		double res = num1; // Hay múltiples opciones ...
      	switch(op)
    	{
        	case('+'): res+=num2; break;
        	case('-'): res-=num2; break;
        	case('*'): res*=num2; break;
        	case('/'): res/=num2; break;
        	default: res=-1;
    	}
    	return res;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try {
    		
    		double num1 = Double.parseDouble(request.getParameter("num1"));
    		double num2 = Double.parseDouble(request.getParameter("num2"));
    		char operator = request.getParameter("operator").charAt(0);
    		double sum = 0;
    		
    	    sum = operacion(operator, num1, num2);
    		if(operator == '/' && num2 == 0) {response.sendError(446, "Operación inválida");}

    		if(sum==-1) response.sendError(445, "Operador no valido");
    		else {    		
    			PrintWriter out = response.getWriter();
    			out.println(sum);
    			/*out.("\n" + 
    			"<!DOCTYPE html>\n"+
    			"<html>" +
    			"<head><title>Calculadora</title>\n"+

    			"<script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>\n"+
    			"<script>\n"+
    			    "$(document).ready(function() { \n"+                                                  
    			        "$('#calculator').submit(function() {                                         \n"+
    			            "$form = $(this);                                                         \n"+
    			            "$.post($form.attr('action'), $form.serialize()).done( function(responseText) { \n"+
    			                "$('#result').text(responseText);                                     \n"+
    			            "})\n"+
    			            ".fail(function (jqxhr, textStatus, error){\n"+
    			            	"alert(jqxhr.status +  ' ' + jqxhr.statusText);\n"+
    			            "})\n"+
    			            "return false;   });});\n"+
    			    
    			    
    			  
    			"</script>\n"+


    			"</head>\n"+
    			"<body>\n"+
    			 "<form id='calculator' action='calculatorErr' method='post'>\n"+
    			    "<p>\n"+
    			        "<input name='num1' type='text'  value='"+num1+"'/>\n"+
    			       " <select name='operator'>\\n"+
    			            "<option value='+'> + </option>\n"+
    			            "<option value='-'> - </option>\n"+
    			            "<option value='*'> * </option>\n"+
    			            "<option value='/'> / </option>\n"+
    			        "</select>\n"+
    			        "<input name='num2' type='text'  value='"+num2+"'/>\n"+
    			        "<button type='submit'>Calcular</button>\n"+
    			    "</p>\n"+
    			    "<p>Result: <span id='result'>" + sum + "</span></p>\n"+
    			"</form>\n"+
    			"</body>\n"+
    			"</html>\n", sum);*/

    		}
    	}catch (NullPointerException e1) {
			response.sendError(444,"Valor introduccido no valido o no hay valor");
		}catch (NumberFormatException e2) {
			response.sendError(444, "Introduce un número");
		}catch (Exception e) {
			response.sendError(446,"Operación inválida");
		}
    	
    	
    }
}