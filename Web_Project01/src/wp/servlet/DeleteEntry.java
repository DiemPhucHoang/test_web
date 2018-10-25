package wp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.model.GuestBookEntry;

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries=(List<GuestBookEntry>)getServletContext().getAttribute("entries");
		int index=Integer.parseInt(request.getParameter("index"));
		entries.remove(index);
		response.sendRedirect("GuestBook");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
