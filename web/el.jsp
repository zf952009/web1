<%@ page import="cn.itcast.domain.Tb_web" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.06.04
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>

<%
    request.setAttribute("name", "zoufang");
    Tb_web tb_web = new Tb_web();
    tb_web.setId(1);
    tb_web.setName("tb_web");
    tb_web.setUrl("www.baidu.con");
    tb_web.setWeb("www");
    session.setAttribute("session", tb_web);


    List<Tb_web> list = new ArrayList<Tb_web>();

    Tb_web tb_web1 = new Tb_web();
    tb_web1.setId(1);
    tb_web1.setName("tb_web");
    tb_web1.setUrl("www.baidu.con");
    tb_web1.setWeb("www");
    Tb_web tb_web2 = new Tb_web();
    tb_web2.setId(1);
    tb_web2.setName("tb_web");
    tb_web2.setUrl("www.baidu.con");
    tb_web2.setWeb("www");
    list.add(tb_web);
    list.add(tb_web1);
    list.add(tb_web2);
    application.setAttribute("list", list);
%>
<%=request.getAttribute("name")%>
<hr/>
<%=application.getAttribute("list")%>
<hr/>
<%
    Tb_web sessionTb_web = (Tb_web) session.getAttribute("session");
    out.write(sessionTb_web.getName());
%>
<hr/>
${applicationScope.list[0].name}
<hr/>
${name}
<hr/>
${session.name}
<hr/>
${session.url}
<hr/>
${pageContext.request.contextPath}
<hr/>

<%--empty:判断对象是否为空，不为空返回false ，为空返回true--%>
${empty session}
${1==1?true:false}

</body>
</html>
