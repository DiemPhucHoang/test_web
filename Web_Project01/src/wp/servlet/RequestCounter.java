package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestCounter")
public class RequestCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    
    public RequestCounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Integer counter=0;
		ServletContext context= getServletContext();
		context.setAttribute("Counter", counter);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context= getServletContext();
		Integer counter=(Integer)context.getAttribute("Counter");
		counter++;
		
		context.setAttribute("Counter", counter);
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>RequestCounter</title></head><body>");
		out.println("The counter has increased");
		out.println("<p>The counter value is currently: "+counter+"</p>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
