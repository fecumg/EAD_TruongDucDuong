package fpt.edu.servlets.publisher;

import fpt.edu.daos.PublisherDao;
import fpt.edu.dtos.PublisherRequest;
import fpt.edu.entities.Publisher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Truong Duc Duong
 */

@WebServlet("/publisher-newPublisher")
public class NewPublisherServlet extends HttpServlet {
    private PublisherDao publisherDao;
    private PublisherAssist publisherAssist;

    @Override
    public void init() throws ServletException {
        publisherDao = new PublisherDao();
        publisherAssist = new PublisherAssist();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("publisher/publisherForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            PublisherRequest publisherRequest = publisherAssist.getPublisherRequest(request);
            Publisher newPublisher = new Publisher(publisherRequest);
            publisherDao.save(newPublisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("publisher");
    }
}
