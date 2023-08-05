package fpt.edu.servlets.book;

import fpt.edu.daos.BookDao;
import fpt.edu.entities.Book;
import fpt.edu.responses.Result;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Truong Duc Duong
 */

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookDao bookDao;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Book> books;
        Result result;

        try {
            String search = request.getParameter("search");
            books = bookDao.search(search);

            request.setAttribute("search", search);
            request.setAttribute("books", books);
            result = new Result(0, "Data acquired");
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
            result = new Result(1, e.getMessage());
            request.setAttribute("result", result);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("book/book.jsp");
        dispatcher.forward(request, response);
    }
}
