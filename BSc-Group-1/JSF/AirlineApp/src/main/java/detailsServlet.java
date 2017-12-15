import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detailsServlet")
public class detailsServlet extends HttpServlet{
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//reading from fields in html
		String fname = request.getParameter("fname");
		String sname = request.getParameter("sname");
		String email = request.getParameter("email");
		
		//reading from radio buttons in html
		String flightclass = request.getParameter("class");
		
		//reading from dropdown in html
		String depart = request.getParameter("depart");
		String dest = request.getParameter("dest");
		String freq = request.getParameter("freq");
				
	}

}
