package shubham;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class result
 */
@WebServlet("/result")
public class result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		
		try(PrintWriter pw = resp.getWriter()) {
			
			Cal_class cal = (Cal_class) req.getAttribute("cal_data");
			
			switch (cal.getOperation()) {
			case "add":
				int res = cal.getNum1() + cal.getNum2();
				pw.print("<h2>res after cal is : "+res+" </h2>");
				break;
				
			case "subtract":
				int res1 = cal.getNum1() - cal.getNum2();
				pw.print("<h2>res after cal is : "+res1+" </h2>");		
				break;
			
			case "multiply":
				int res2 = cal.getNum1() * cal.getNum2();
				pw.print("<h2>res after cal is : "+res2+" </h2>");		
				break;
				
			case "divide":
				int res3 = cal.getNum1() / cal.getNum2();
				pw.print("<h2>res after cal is : "+res3+" </h2>");		
				break;

			default:
				pw.print("<h4><a href='calculate'>Re_Calculate</a></h4>");
				
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	
	}

}
