package fpt.edu.servlets.publisher;

import fpt.edu.daos.PublisherDao;

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

@WebServlet("/publisher-deletePublisher")
public class DeletePublisherServlet extends HttpServlet {
    private PublisherDao publisherDao;

    @Override
    public void init() throws ServletException {
        publisherDao = new PublisherDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            publisherDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("publisher");
    }
}
