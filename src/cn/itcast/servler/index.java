package cn.itcast.servler;

import cn.itcast.dao.Tb_WebDao;
import cn.itcast.dao.impl.Tb_WebDaoImpl;
import cn.itcast.domain.Tb_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "index", urlPatterns = "/index")
public class index extends HttpServlet {
    Tb_WebDao tb_webDao = new Tb_WebDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Tb_web> tbWebs = tb_webDao.getAll();
        request.setAttribute("data",tbWebs);

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}