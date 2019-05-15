import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcServlet
 */
@WebServlet(urlPatterns="/calculator")
public class calcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private int operacion (char op, int n1, int n2)
	{
		int res = n1; // Hay m�ltiples opciones ...
      	switch(op)
    	{
        	case('+'): res+=n2; break;
        	case('-'): res-=n2; break;
        	case('*'): res*=n2; break;
        	case('/'): res/=n2;
    	}
    	return res;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	int num1 = Integer.parseInt(request.getParameter("num1"));
    	int num2 = Integer.parseInt(request.getParameter("num2"));
    	char operator = request.getParameter("operator").charAt(0);
    	int sum = operacion(operator, num1, num2);

    	response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(String.valueOf(sum));
    }
}