/**
 * 创建webSocket链接
 */
var socket;
if(typeof(WebSocket) == "undefined") {
    console.error("您的浏览器不支持WebSocket");
}else{
    var account = getCookie("account");
    if(account != null && account !== undefined && account !== ""){
        var serverPath = window.location.origin + "/websocket/" + account;
        socket = new WebSocket(serverPath.replace("http","ws"));
        initSocket(socket)
    }else {
        console.error("用户信息不存在，无法建立链接");
    }
}

function initSocket(socket) {
    socket.onopen = function() {
        console.log("Socket 已打开");
        //socket.send("这是来自客户端的消息" + location.href + new Date());
    };
    //获得消息事件
    socket.onmessage = function(msg) {
        console.log(msg.data);
        //发现消息进入    开始处理前端触发逻辑
    };
    //关闭事件
    socket.onclose = function() {
        console.log("Socket已关闭");
    };
    //发生了错误事件
    socket.onerror = function() {
        alert("与服务器链接短开，请刷新重试");
    }
    //页面关闭时释放链接
    window.onbeforeunload = function(e) {
        socket.close();
        return 1;
    };
}