
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>-------</h1>
<form action="/goodnews/crocodile/register" method="post">
    <table style="with: 50%">
        <tr>
            <td>Username</td>
            <td><label>
                <input type="text" name="userName" />
            </label>Name</td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                <input type="password" name="password" />
            </label>Password</td>
        </tr>
    </table>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Submit" />Зарегистрировать</form>
</body>
</html>
