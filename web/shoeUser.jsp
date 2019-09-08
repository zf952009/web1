<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.17
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,com.listener.*"  %>
<%@ page import="cn.itcast.servler.UserInfoList" %>
<%@ page import="cn.itcast.servler.UserInfoTrace" %>
<%
    UserInfoList list = UserInfoList.getInstance();
    UserInfoTrace trace = new UserInfoTrace();
    String name = request.getParameter("user");
    trace.setUser(name);
    session.setAttribute("list",trace);
    list.addUserInfoList(trace.getUser());
    session.setMaxInactiveInterval(100);
%>
<textarea rows="8" cols="20">
    <%
        Vector vector = list.getList();
        if (vector!=null&&vector.size()>0){
            for (int i=0;i<vector.size();i++){

                out.println(vector.elementAt(i));
            }
        }
    %>
</textarea>

