package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayCounter")
public class DisplayCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int counter;
    
    public DisplayCounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		counter=0;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		++counter;
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>RequestCounter</title></head><body>");
		out.println("You are visitor #"+counter+".");
		out.println("</body></html>");
	}

}
