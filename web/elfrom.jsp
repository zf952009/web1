<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.06.04
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("cookie","shafang");
    response.addCookie(cookie);
%>


${param.name}
<hr/>
${header.host}
<hr/>
${header["User-Agent"]}
<hr/>
${initParam.elname}
<hr/>
${cookie.cookie.value}
<hr/>
${pageContext.request.contextPath}
<hr/>
<hr/>
${pageContext.request.contextPath}

</body>
</html>
