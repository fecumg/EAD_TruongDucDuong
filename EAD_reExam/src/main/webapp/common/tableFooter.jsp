<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: truongduong
  Date: 16/11/2022
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tfoot>
    <tr>
        <c:if test="${result != null}">
            <td colspan="100%">
                <c:if test="${result.status == 0}">
                    <span style="color: green">
                </c:if>
                <c:if test="${result.status == 1}">
                    <span style="color: red">
                </c:if>
                        <c:out value="${result.message}"/>
                    </span>
            </td>
        </c:if>
    </tr>
</tfoot>
