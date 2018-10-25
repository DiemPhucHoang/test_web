package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Add() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int a=0,b=0;
		//if(request.getParameter("a")!=null)
		//	a=Integer.parseInt(request.getParameter("a"));
		//if(request.getParameter("b")!=null)
		//	b=Integer.parseInt(request.getParameter("b"));
		String a=request.getParameter("a");
		String b=request.getParameter("b");
		if(a==null||b==null||a.trim().length()==0||b.trim().length()==0)
		{
			response.sendRedirect("AddForm.html");
			return;
		}
		int sum=Integer.parseInt(a)+Integer.parseInt(b);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>ADD</title></head><body>");
		out.println("<p>"+a+"+"+b+"="+ sum+"</p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
