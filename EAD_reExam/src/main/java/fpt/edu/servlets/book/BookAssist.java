package fpt.edu.servlets.book;

import fpt.edu.dtos.BookRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Truong Duc Duong
 */
public class BookAssist {

    public BookRequest getBookRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        int publisherId = Integer.parseInt(request.getParameter("publisherId"));
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");

        return new BookRequest(name, publisherId, author, genre);
    }
}
