<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Крокодил</title>
</head>
<body>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Sign Out">
    </form>
</div>
<a href="/goodnews/crocodile/game">К игре</a>
<a href="/goodnews/crocodile/register">Регистрация</a>
<a href="/goodnews/crocodile/chatTemp">Чат</a>
</body>
</html>
