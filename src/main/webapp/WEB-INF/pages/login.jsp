<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>-Логин-</title>
</head>
<body>
<h1>Логин</h1>
<form action="/goodnews/crocodile/login" method="post">
    <div><label>User name: <input type="text" name="userName"/></label></div>
    <div><label>Password: <input type="password" name="password"/></label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Submit"/></div>
</form>
<a href="/goodnews/crocodile/register">Перейти к регистрации</a>
</body>
</html>