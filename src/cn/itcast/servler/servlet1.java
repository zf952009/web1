package cn.itcast.servler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet1", urlPatterns = "/servlet1")
public class servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //返回请求的上下文路径，此路径以“/”开头
        String path = request.getContextPath();
        //返回的请求发送的所有cooki对象，返回值为cookie数组
        Cookie[] cookies =  request.getCookies();
        //返回请求所使用的的http类型。如get，post
        String moethod = request.getMethod();
        //返回请求中参数的字符串形式，
        String queryString = request.getQueryString();
        //返回主机名到请求参数之间的字符串形式
        String url = request.getRequestURI();
        StringBuffer stringBuffer = request.getRequestURL();
        //返回请求URL中的servlet路径的字符串，不包含请求中的参数信息
        String servletPath = request.getServletPath();
        //返回session对象
        HttpSession httpSession = request.getSession();

        //向客户端写入cookie信息
        response.addCookie(new Cookie("name","cookiename"));
        //发送一个错误状态码
        response.sendError(404);
        //发送一个错误的状态码和错误信息
        response.sendError(404,"error");
        //客户端重定向新的url，参数为新的地址
        response.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}