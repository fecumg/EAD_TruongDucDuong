
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .small-avatar {
        height: 40px;
        width: 40px;
        border-radius: 50%;
        border: 1px solid gray;
        object-fit: cover;
        margin-bottom: -15px;
    }

    .menu-item {
        text-decoration: none;
        color: black;
        border: 0.5px solid black;
        margin-right: 10px;
        padding: 5px
    }
</style>


<a class="menu-item" href="/book">
    Books
</a>
<a  class="menu-item" href="/publisher">
    Publishers
</a>

