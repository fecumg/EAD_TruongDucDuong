package fpt.edu.servlets.book;

import fpt.edu.daos.BookDao;
import fpt.edu.daos.PublisherDao;
import fpt.edu.dtos.BookRequest;
import fpt.edu.entities.Book;
import fpt.edu.entities.Publisher;
import fpt.edu.responses.Result;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@WebServlet("/book-newBook")
public class NewBookServlet extends HttpServlet {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private BookAssist bookAssist;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDao();
        publisherDao = new PublisherDao();
        bookAssist = new BookAssist();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Publisher> publishers;
        Result result;
        try {
            publishers = publisherDao.getAll();

            request.setAttribute("publishers", publishers);
            result = new Result(0, "Data acquired");
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
            result = new Result(1, e.getMessage());
            request.setAttribute("result", result);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("book/bookForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Book newBook;
        try {
            BookRequest bookRequest = bookAssist.getBookRequest(request);
            newBook = new Book(bookRequest);

            if (bookRequest.getPublisherId() != 0) {
                Publisher publisher = publisherDao.get(bookRequest.getPublisherId());
                newBook.setPublisher(publisher);
            }

            bookDao.save(newBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("book");
    }
}
