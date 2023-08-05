<%--
  Created by IntelliJ IDEA.
  User: truongduong
  Date: 15/11/2022
  Time: 08:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Management Application</title>
    <jsp:include page="../common/plugins.jsp"/>
</head>
<body>
<center>
    <jsp:include page="../common/menu.jsp"/>
    <h1>Publisher Management</h1>
</center>
<div align="center">
    <c:if test="${publisher != null}">
    <form action="publisher-editPublisher" method="post">
        </c:if>
        <c:if test="${publisher == null}">
        <form action="publisher-newPublisher" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <a href="/publisher" style="text-decoration: none; color: black">
                            <i class="fa-solid fa-arrow-left-long"></i>
                        </a>
                        <c:if test="${publisher != null}">
                            Edit Publisher
                        </c:if>
                        <c:if test="${publisher == null}">
                            Add New Publisher
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${publisher != null}">
                    <input type="hidden" name="id" value="${publisher.id}" />
                </c:if>
                <tr>
                    <th>Publisher Name: </th>
                    <td>
                        <input type="text" name="name" size="45" required
                               value="${publisher.name}"
                        />
                    </td>
                </tr>

                <tr>
                    <th>Address: </th>
                    <td>
                        <textarea name="address" cols="40" rows="2" required><c:out value="${publisher.address}"></c:out></textarea>
                    </td>
                </tr>

                <tr>
                    <th>Contact person: </th>
                    <td>
                        <textarea name="contactPerson" cols="40" rows="2" required><c:out value="${publisher.contactPerson}"></c:out></textarea>
                    </td>
                </tr>

                <tr>
                    <th>Phone: </th>
                    <td>
                        <input type="tel" name="phone" size="45" required
                               value="${publisher.phone}"
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
</body>
</html>
