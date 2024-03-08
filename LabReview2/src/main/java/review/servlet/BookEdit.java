package review.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import review.beans.Book;
import review.conn.ConnectionUtils;
import review.utils.BookUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import review.beans.Book;
import review.conn.ConnectionUtils;
import review.utils.BookUtils;


/**
 * Servlet implementation class BookEdit
 */
public class BookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/BookEdit");
		String BookId = (String) request.getParameter("BookId");
		if(BookId == null || BookId == "") {
			errorString="Ban chua chon sach can sua";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		Book book = null;
		errorString = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			book = BookUtils.findBook(conn, BookId);
			if(book==null) {
				errorString="Khong tim thay sach co ma " + BookId;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if(errorString != null || book ==null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("Book", book);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lieu tren form
		String BookId = (String) request.getParameter("BookId");
		String Title = (String) request.getParameter("Title");
		String Author = (String) request.getParameter("Author");
		int Release = Integer.parseInt( request.getParameter("Release"));
		float Price = Float.parseFloat(request.getParameter("Price"));
		String Picture = (String) request.getParameter("Picture");
		int PublisherId = Integer.parseInt(request.getParameter("PublisherId"));
		int CategoryId = Integer.parseInt(request.getParameter("CategoryId"));
		
		
		Book book = new Book(BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId);
	}

}
