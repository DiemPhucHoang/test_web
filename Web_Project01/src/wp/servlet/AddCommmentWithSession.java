package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.model.GuestBookEntry;

@WebServlet("/AddCommmentWithSession")
public class AddCommmentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AddCommmentWithSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>AddCommentWithSession</title></head><body>");
		out.println("<form action='AddCommmentWithSession' method='Post'>");
		
		//if we already have name in a cookie, then just display name
		String name=(String)request.getSession().getAttribute("name");
		if(name!=null)
			out.println("Name: "+name+"</br>");
		//otherwise, display the input field
		else
			out.println("Name: <input type='text' name='name'></br>");
		
		
		out.println("Message:</br> <textarea name='message' rows='5' cols='60'></textarea></br>");
		out.println("<input type='submit' name='add' value='Add'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//first try to get name from cookie
		String name=(String)request.getSession().getAttribute("name");
		if(name==null)
		{
			//get the user input
			name=request.getParameter("name");
			request.getSession().setAttribute("name", name);
		}
		
		String message=request.getParameter("message");
		
		//create a guest book entry
		GuestBookEntry entry=new GuestBookEntry(name,message);
		
		//add the new entry to the guest book
		List<GuestBookEntry> entries=(List<GuestBookEntry>)getServletContext().getAttribute("entries");
		entries.add(entry);
		
		//send user back to guest book
		response.sendRedirect("GuestBook");
	}

}


