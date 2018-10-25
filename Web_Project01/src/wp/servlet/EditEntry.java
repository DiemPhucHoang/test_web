package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.model.GuestBookEntry;


@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditEntry() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries=(List<GuestBookEntry>)getServletContext().getAttribute("entries");
		int index=Integer.parseInt(request.getParameter("index"));
		GuestBookEntry entry=entries.get(index);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>EditEntry</title></head><body>");
		out.println("<form action='EditEntry' method='Post'>");
		out.println("Name: <input type='text' name='name'value='"+entry.getName()+"'></br>");
		out.println("Message:</br> <textarea name='message' rows='5' cols='60'>"+entry.getMessage()+"</textarea></br>");
		out.println("<input type='hidden' name='index' value='"+index+"'>");
		out.println("<input type='submit' name='add' value='Add'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries=(List<GuestBookEntry>)getServletContext().getAttribute("entries");
		String name=request.getParameter("name");
		String message=request.getParameter("message");
		int index=Integer.parseInt(request.getParameter("index"));
		//entries.add(new GuestBookEntry(name,message));
		entries.get(index).setName(name);
		entries.get(index).setMessage(message);
		response.sendRedirect("GuestBook");
	}

}
