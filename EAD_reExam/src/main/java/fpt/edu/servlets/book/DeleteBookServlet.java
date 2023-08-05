package fpt.edu.servlets.book;

import fpt.edu.daos.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Truong Duc Duong
 */

@WebServlet("/book-deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private BookDao bookDao;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            bookDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("book");
        }
    }
}
