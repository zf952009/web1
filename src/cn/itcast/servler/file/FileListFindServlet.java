package cn.itcast.servler.file;

import cn.itcast.domain.File_List;
import cn.itcast.service.FileListService;
import cn.itcast.service.impl.FileListServiceImpl;
import cn.itcast.utils.FileListUtils;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FileListFindServlet", urlPatterns = "/FileListFind")
public class FileListFindServlet extends HttpServlet {

    FileListService fileListService = new FileListServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        File_List fileList = FileListUtils.request2Object(request, File_List.class);
        List<File_List> file_lists = fileListService.find(fileList);
        int count = file_lists.size();
        if(count==0){
            List<File_List> all = fileListService.getAll();
            request.setAttribute("count",all.size());
            String string = JSON.toJSONString(all);
            response.getWriter().print(string);
            return;
        }
        request.setAttribute("count",count);
        String string = JSON.toJSONString(file_lists).toString();
        response.getWriter().print(string);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}