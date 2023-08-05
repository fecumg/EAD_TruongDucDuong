package fpt.edu.servlets.publisher;

import fpt.edu.dtos.PublisherRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Truong Duc Duong
 */
public class PublisherAssist {
    public PublisherRequest getPublisherRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String contactPerson = request.getParameter("contactPerson");
        String phone = request.getParameter("phone");

        return new PublisherRequest(name, address, contactPerson, phone);
    }
}
