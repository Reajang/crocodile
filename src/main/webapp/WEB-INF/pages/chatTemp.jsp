<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Макет чата</title>
</head>
<body>
<h1>==========================</h1>
<form action="/goodnews/crocodile/chatTemp" method="get">

<%--    <c:forEach var="message" items="${messages}">
        <tr>
            <td><c:out value="${message}"/> </td>
        </tr>
    </c:forEach>--%>

</form>
<form action="/goodnews/crocodile/chatTemp" method="post">
    <label>Сообщение
        <input type="text" name="text"/>
    </label>
</form>
</body>
</html>
