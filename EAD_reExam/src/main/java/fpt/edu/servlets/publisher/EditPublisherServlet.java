package fpt.edu.servlets.publisher;

import fpt.edu.daos.PublisherDao;
import fpt.edu.dtos.PublisherRequest;
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

/**
 * @author Truong Duc Duong
 */

@WebServlet("/publisher-editPublisher")
public class EditPublisherServlet extends HttpServlet {
    private PublisherDao publisherDao;
    private PublisherAssist publisherAssist;

    @Override
    public void init() throws ServletException {
        publisherDao = new PublisherDao();
        publisherAssist = new PublisherAssist();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result result;

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Publisher publisher = publisherDao.get(id);
            request.setAttribute("publisher", publisher);
            result = new Result(0, "Data acquired");
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
            result = new Result(1, e.getMessage());
            request.setAttribute("result", result);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("publisher/publisherForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result result;
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            PublisherRequest publisherRequest = publisherAssist.getPublisherRequest(request);
            Publisher publisher = new Publisher(publisherRequest);
            publisher.setId(id);

            publisherDao.update(publisher);
            request.setAttribute("publisher", publisher);
            result = new Result(0, "Publisher updated successfully");
            request.setAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(1, e.getMessage());
            request.setAttribute("result", result);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("publisher/publisherForm.jsp");
        dispatcher.forward(request, response);
    }
}
