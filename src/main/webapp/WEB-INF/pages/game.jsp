<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Крокодил</title>

</head>
<body>

<canvas id="frame" width="350" height="600"
        style="background-color:#eee; border: 1px solid #ccc; margin:10px;">
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

<%--Почему не работает?<script src="/resources/js/canvFrame.js"></script>--%>
</body>
</html>
