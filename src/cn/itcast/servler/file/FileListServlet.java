package cn.itcast.servler.file;

import cn.itcast.domain.File_List;
import cn.itcast.service.FileListService;
import cn.itcast.service.impl.FileListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FileListServlet", urlPatterns = "/FileList")
public class FileListServlet extends HttpServlet {
    FileListService fileListService = new FileListServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<File_List> all = fileListService.getAll();
        int count = all.size();
        request.setAttribute("id",count+1);
        request.setAttribute("count",count);
        request.setAttribute("data",all);
        request.getRequestDispatcher("/file_list.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}