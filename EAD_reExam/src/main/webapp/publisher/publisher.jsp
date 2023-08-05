<%--
  Created by IntelliJ IDEA.
  User: truongduong
  Date: 14/11/2022
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Management Application</title>
    <jsp:include page="../common/plugins.jsp"/>
</head>
<body>
<center>
    <jsp:include page="../common/menu.jsp"/>
    <h1>Publisher Management</h1>
    <h2>
        <a href="publisher-newPublisher">Add new publisher</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Publishers</h2></caption>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Address</th>
            <th>Contact person</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        <c:forEach var="publisher" items="${publishers}" varStatus="loop">
            <tr>
                <td>
                    <c:out value="${loop.index + 1}" />
                </td>
                <td><c:out value="${publisher.name}" /></td>
                <td><c:out value="${publisher.address}" /></td>
                <td><c:out value="${publisher.contactPerson}" /></td>
                <td><c:out value="${publisher.phone}" /></td>
                <td>
                    <a href="publisher-editPublisher?id=<c:out value='${publisher.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="publisher-deletePublisher?id=<c:out value='${publisher.id}' />">Delete</a>
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
