<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Крокодил</title>
    <style>
        .frame {
            background-color: #eee;
            border: 1px solid #ccc;
            float: left;
            /*width: 25%;
            height: 80%;*/
        }

        #chat {
            float: right;
            /*width: 200px;*/
            height: 80%;
            overflow: scroll;
        }

        #messageInput{

        }
    </style>
</head>
<body>
<div class="frame">
    <canvas id="frame" width="400" height="800">
        Ваш браузер не поддерживает Canvas
    </canvas>
    <script>
        var canvFrame = document.getElementById("frame");
        var context = canvFrame.getContext("2d");
        w = canvFrame.width;
        h = canvFrame.height;

        var mouse = {x: 0, y: 0};
        var draw = false;

        canvFrame.addEventListener("mousedown", function (e) {

            mouse.x = e.pageX - this.offsetLeft;
            mouse.y = e.pageY - this.offsetTop;
            draw = true;
            context.beginPath();
            context.moveTo(mouse.x, mouse.y);
        });
        canvFrame.addEventListener("mousemove", function (e) {

            if (draw == true) {

                mouse.x = e.pageX - this.offsetLeft;
                mouse.y = e.pageY - this.offsetTop;
                context.lineTo(mouse.x, mouse.y);
                context.stroke();
            }
        });
        canvFrame.addEventListener("mouseup", function (e) {

            mouse.x = e.pageX - this.offsetLeft;
            mouse.y = e.pageY - this.offsetTop;
            context.lineTo(mouse.x, mouse.y);
            context.stroke();
            context.closePath();
            draw = false;
        });
    </script>
</div>

<div id="chat">
    <div id="readMessages">
        <form action="/goodnews/crocodile/game" method="get">
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
    </div>
    <div id="messageInput">
        <form action="/goodnews/crocodile/game" method="post">
            <label>Сообщение
                <input type="text" name="text"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </label>
        </form>
    </div>
</div>
<script type="text/javascript">
    var block = document.getElementById("chat");
    block.scrollTop = block.scrollHeight;
</script>
<%--Почему не работает?<script src="/resources/js/canvFrame.js"></script>--%>
</body>
</html>
