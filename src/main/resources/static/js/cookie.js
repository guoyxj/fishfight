function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)===0) return c.substring(name.length,c.length);
    }
    return "";
}

function delCookie(name) {
    var exp = new Date();
    exp.setTime (exp.getTime() - 1);
    var cval = getCookie(name);
    document.cookie = name + "=" + cval + ";Path=/;expires="+ exp.toGMTString();
}