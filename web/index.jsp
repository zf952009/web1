<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.17
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8"/>

<head>
  <title>管理首页</title>
</head>
<frameset rows="65,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="header.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame"
         target="main"/>
  <frameset cols="193,*" frameborder="no" border="0" framespacing="0">
    <frame src="${pageContext.request.contextPath}/left.jsp" scrolling="No" noresize="noresize" id="leftFrame" target="main"/>
    <frame src="${pageContext.request.contextPath}/FileList" name="mainFrame" id="mainFrame"/>
   <%-- <frame src="${pageContext.request.contextPath}/file_list_vue.jsp" name="mainFrame" id="mainFrame"/>--%>
  </frameset>
</frameset>
<noframes>
  <body>
  </body>
</noframes>
</html>z