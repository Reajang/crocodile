
window.onload = function () {
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
}

