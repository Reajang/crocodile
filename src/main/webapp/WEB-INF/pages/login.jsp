<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>-Логин-</title>
</head>
<body>
<h1>Логин</h1>
<form action="/goodnews/crocodile/login" method="post">
    <table style="with: 50%">
        <tr>
            <td>Username</td>
            <td><label>
                <input type="text" name="userName"/>
            </label></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                <input type="password" name="password"/>
            </label></td>
        </tr>
    </table>
    <input type="submit" value="Submit"/>Войти
</form>
<a href="/goodnews/crocodile/register">Перейти к регистрации</a>
</body>
</html>