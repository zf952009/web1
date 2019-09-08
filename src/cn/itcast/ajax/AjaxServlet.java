package cn.itcast.ajax;

import cn.itcast.domain.File_List;
import cn.itcast.service.FileListService;
import cn.itcast.service.impl.FileListServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AjaxServlet", urlPatterns = "/ajaxServlet")
public class AjaxServlet extends HttpServlet {
    FileListService fileListService = new FileListServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<File_List> all = fileListService.getAll();
        String jsonString = JSON.toJSONString(all);
        PrintWriter writer = response.getWriter();
        writer.print(jsonString);
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}