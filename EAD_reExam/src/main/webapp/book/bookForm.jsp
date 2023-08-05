<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>Book Management Application</title>
  <jsp:include page="../common/plugins.jsp"/>
</head>
<body>
<center>
  <jsp:include page="../common/menu.jsp"/>
  <h1>Book Management</h1>
</center>
<div align="center">
  <c:if test="${book != null}">
    <form action="book-editBook" method="post">
  </c:if>
  <c:if test="${book == null}">
    <form action="book-newBook" method="post">
  </c:if>
      <table border="1" cellpadding="5">
        <caption>
          <h2>
            <a href="/book" style="text-decoration: none; color: black">
              <i class="fa-solid fa-arrow-left-long"></i>
            </a>

            <c:if test="${book != null}">
              Edit Book
            </c:if>
            <c:if test="${book == null}">
              Add New Book
            </c:if>
          </h2>
        </caption>
        <c:if test="${book != null}">
          <input type="hidden" name="id" value="${book.getId()}" />
        </c:if>
        <tr>
          <th>Book Name: </th>
          <td>
            <input type="text" name="name" size="45" required maxlength="100" required
                   value="${book.name}"
            />
          </td>
        </tr>

        <tr>
          <th>Publisher: </th>
          <td>
            <select name="publisherId" required>
              <option value="">Select a publisher</option>
              <c:forEach var="publisher" items="${publishers}">
                <option value="${publisher.getId()}" ${publisher.getId() == book.publisher.id ? 'selected="true"' : 'false'}>${publisher.getName()}</option>
              </c:forEach>
            </select>
          </td>
        </tr>

        <tr>
          <th>Author: </th>
          <td>
            <input type="text" name="author" size="45" required maxlength="100" required
                   value="${book.author}"
            />
          </td>
        </tr>

        <tr>
          <th>Genre: </th>
          <td>
            <input type="text" name="genre" size="45" required maxlength="100" required
                   value="${book.genre}"
            />
          </td>
        </tr>

        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="Save" />
          </td>
        </tr>

        <jsp:include page="../common/tableFooter.jsp">
          <jsp:param name="result" value="${result}"/>
        </jsp:include>
      </table>
    </form>
</div>

<jsp:include page="../common/imageProcessor.jsp"></jsp:include>
</body>
</html>