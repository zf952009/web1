package cn.itcast.servler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "doument", urlPatterns = "/document")
public class doument extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String file ="惊奇队长.mkv";
        String filepath = "D:\\毕业照片\\视频\\电影\\"+file;
        FileInputStream fileInputStream = new FileInputStream(filepath);
        //向客户端发送下载头
        response.setHeader("Content-Disposition", "attachment; filename="+"惊奇队长mkv");
        OutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024*3*1000];
        int length = 0;
        while((length=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,length);
        }
        String url="/JavaWeb/index.html";
        response.setStatus(200);
        response.sendRedirect(url);
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}