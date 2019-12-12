<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Макет чата</title>
</head>
<body>
<h1>==========================</h1>
<form action="/goodnews/crocodile/chatTemp" method="get">

    <h1>Чат</h1>

    <table border="1">
        <tr>
            <th>Автор</th>
            <th>Текст</th>
            <th>Дата создания</th>
        </tr>
        <c:forEach var="message" items="${messages}">
            <tr>
                <td><c:out value="${message.author.userName}"/></td>
                <td><c:out value="${message.text}"/></td>
                <td><c:out value="${message.creationDate}"/></td>
            </tr>
        </c:forEach>
    </table>


</form>
<form action="/goodnews/crocodile/chatTemp" method="post">
    <label>Сообщение
        <input type="text" name="text"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </label>
</form>
</body>
</html>
--%>
