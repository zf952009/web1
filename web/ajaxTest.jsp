<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.23
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax测试方式</title>
</head>
<body>
<div id="showInfo"></div>
</body>
<script type="javascript" charset="UTF-8" src="public/js/ajaxRequest.js"></script>
<script>
    function onerror() {
        alert("操作有误");
    }
    function getInfo() {
        var loader=new net.ajaxRequest("ajaxTest.jsp?oncache="+new Date().getTime(),deal_getInfo,onerror,"GET");
    }
    function deal_getInfo() {
        document.getElementById("showInfo").innerHTML=this.request.responseText;
    }


</script>
</html>
