package fpt.edu.servlets.publisher;

import fpt.edu.daos.PublisherDao;
import fpt.edu.entities.Publisher;
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

@WebServlet("/publisher")
public class PublisherServlet extends HttpServlet {
    private PublisherDao publisherDao;

    @Override
    public void init() throws ServletException {
        publisherDao = new PublisherDao();
    }

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

        RequestDispatcher dispatcher = request.getRequestDispatcher("publisher/publisher.jsp");
        dispatcher.forward(request, response);
    }
}
