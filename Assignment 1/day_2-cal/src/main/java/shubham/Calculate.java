package shubham;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Calculate
 */
@WebServlet(value = "/calculate", loadOnStartup = 1)
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		
		try(PrintWriter pw = response.getWriter())
		{
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			
			String action = request.getParameter("action");
			
			
			switch (action) {
			case "add":
				int res = num1 + num2;
				pw.print("<h5>res is : "+res+" </h5>");		
				break;
				
			case "subtract":
				int res1 = num1 - num2;
				pw.print("<h5>res is : "+res1+" </h5>");		
				break;
			
			case "multiply":
				int res2 = num1 * num2;
				pw.print("<h5>res is : "+res2+" </h5>");		
				break;
				
			case "divide":
				int res3 = num1 / num2;
				pw.print("<h5>res is : "+res3+" </h5>");		
				break;

			default:
				break;
			}
			
		}
				

	}

}
