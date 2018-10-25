package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int counter=10;
    public Countdown() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//if counter =0, in 1 message
		if(counter==0)
			out.println("<p>Rocket laughted</p>");
		//if counter ko đếm đc tới 0, set a refresh header, tăng counter
		else
		{
			out.println("<h2>"+counter+"</h2>");
			response.setHeader("Refresh", "1");
			--counter;
		}
		
	}

}
