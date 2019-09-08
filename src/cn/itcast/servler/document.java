package cn.itcast.servler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "document", urlPatterns = "/document1")
public class document extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取文件路径
        //文件流，读取文件
        FileInputStream fileInputStream = new FileInputStream("C:\\user\\ideaProject\\JavaWeb\\web\\document\\office 2019.rar");
        //向客户端发送文件下载头
        response.setHeader("Content-Disposition", "attachment; filename=office 2019.rar");
        OutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int lenth=0;
        //文件流下载
        while ((lenth=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,lenth);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}