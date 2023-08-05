
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Management Application</title>
    <jsp:include page="../common/plugins.jsp"/>
<body>
<center>
    <jsp:include page="../common/menu.jsp"/>
    <h1>Book Management</h1>
    <h2>
        <a href="book-newBook">Add new book</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Books</h2></caption>
        <form method="get" action="/book">
            <input type="text" name="search" placeholder="Search" value="${search}"/>
            <button type="submit">Search</button>
        </form>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Publisher</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Action</th>
        </tr>
        <c:forEach var="book" items="${books}" varStatus="loop">
            <tr>
                <td>
                    <c:out value="${loop.index + 1}" />
                </td>
                <td><c:out value="${book.getName()}" /></td>
                <td>
                    <c:if test="${book.publisher != null}">
                        <c:out value="${book.publisher.name}" />
                    </c:if>
                </td>
                <td><c:out value="${book.getAuthor()}" /></td>
                <td><c:out value="${book.getGenre()}" /></td>
                <td>
                    <a href="book-editBook?id=<c:out value='${book.getId()}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="book-deleteBook?id=<c:out value='${book.getId()}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>

        <jsp:include page="../common/tableFooter.jsp">
            <jsp:param name="result" value="${result}"/>
        </jsp:include>
    </table>
</div>
</body>
</html>
