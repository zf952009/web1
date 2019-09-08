package cn.itcast.servler.file;

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
import java.util.List;

@WebServlet(name = "FileListAJAXAllServlet", urlPatterns = "/AjaxAll")
public class FileListAJAXAllServlet extends HttpServlet {
    FileListService fileListService = new FileListServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<File_List> all = fileListService.getAll();
        int count = all.size();
        request.setAttribute("count",count);
        String string = JSON.toJSONString(all).toString();
        response.getWriter().print(string);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}