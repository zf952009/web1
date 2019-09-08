<%@ page import="cn.itcast.domain.Tb_web" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sun.xml.internal.ws.model.WrapperBeanGenerator" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.06.04
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>jstlDemo</title>
</head>
<body>

<%
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
    list.add(tb_web1);
    list.add(tb_web2);
    application.setAttribute("list", list);


    Map<String,String> webMap = new LinkedHashMap<String,String>();
    webMap.put("name","zoufang");
    webMap.put("password","123456");
    webMap.put("age","18");
    session.setAttribute("webMap",webMap);

    Map<String,Tb_web> webMap1 = new LinkedHashMap<String,Tb_web>();
    webMap1.put("web1",tb_web1);
    webMap1.put("web2",tb_web2);
    request.setAttribute("webMap1",webMap1);

    Map<Tb_web,Map<String,Tb_web>> m = new LinkedHashMap<Tb_web,Map<String, Tb_web>>();
    m.put(tb_web1,webMap1);
    request.setAttribute("m",m);

%>
jstl
<hr/>

<c:if test="${1==1}">
    shafang
</c:if>
<c:if test="1!=1">
    fangsha
</c:if>
<hr/>
<c:forEach begin="1" end="5" var="i">
    ${i}
    <hr/>
</c:forEach>

<c:forEach var="value" items="${list}">
    ${value}
<hr/>
</c:forEach>


<c:forEach items="${webMap}" var="value">
    ${value.key}=${value.value}
    <hr/>
</c:forEach>

<c:forEach var="value" items="${webMap1}">

    ${value.key}=${value.value.name}----${value.value}
    <hr/>

</c:forEach>


<c:forEach items="${m}" var="value">
    <%--${value.key}==mmmmm==${value.key}--%>
    <c:forEach var="v" items="${value.value}">
        ${v.value}==ccccc==${v.key}
    <hr/>
    </c:forEach>


<hr/>
</c:forEach>

</body>
</html>
