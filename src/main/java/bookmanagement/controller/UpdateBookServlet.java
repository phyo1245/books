package bookmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.models.Book;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/editbook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		Book book = new Book();
		
		List<Book> books = (List<Book>) request.getServletContext().getAttribute("books");
		for (Book b: books) {
			if(b.getCode().equals(code)) {
				book=b;
			}
		}
		request.setAttribute("book", book);
		request.getRequestDispatcher("edit_book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book updateBook = new Book();
		updateBook.setCode(request.getParameter("code"));
		updateBook.setName(request.getParameter("name"));
		String priceStr = request.getParameter("price");
		updateBook.setAuthor(request.getParameter("author"));

		if (updateBook.getCode().equals("") || updateBook.getName().equals("") || priceStr.equals("")
				|| updateBook.getAuthor().equals("")) {
			
			String error="";
			if(updateBook.getCode().equals("")) {
				error += "Code field is required <br>" ;
			}
			
			if(updateBook.getName().equals("")) {
				error += "Name field is required <br>";
			}

			if(priceStr.equals("")) {
				error += "Price field is required <br>";
			}else {
				updateBook.setPrice(Double.parseDouble(priceStr));
			}
			
			if(updateBook.getAuthor().equals("")) {
				error += "Author field is required <br>";
			}
			

			request.setAttribute("book", updateBook);
			request.setAttribute("error_msg", error);
			request.getRequestDispatcher("edit_book.jsp").forward(request, response);

		}		else {
			List<Book> books = (List<Book>) request.getServletContext().getAttribute("books");
			for (Book oldBook : books) {
				if(oldBook.getCode().equals(updateBook.getCode())) {
					oldBook.setName(updateBook.getName());
					oldBook.setPrice(Double.parseDouble(priceStr));
					oldBook.setAuthor(updateBook.getAuthor());

				}
				
			}
			request.getServletContext().setAttribute("books", books);
			response.sendRedirect("books");

		}
		
	}

}
