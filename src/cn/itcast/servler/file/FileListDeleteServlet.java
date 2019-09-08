package cn.itcast.servler.file;

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
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "FileListDeleteServlet", urlPatterns = "/FileListDelete")
public class FileListDeleteServlet extends HttpServlet {
    FileListService fileListService = new FileListServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        Integer id = Integer.valueOf(request.getParameter("id"));

        Map<String, String> data = new LinkedHashMap<>();
        String mes = null;
        if (id!=null || !"".equals(id)){
            mes="error";
        }
        try {
            Integer res = Integer.valueOf(fileListService.delete(id));
            int i = id - res;
            mes = i==0?"ok":"error";
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            mes="error";
        }catch (Exception e){
            e.printStackTrace();
            mes="error";
        }

        data.put("mes", mes);
        String string = JSON.toJSONString(data).toString();
        writer.print(string);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}