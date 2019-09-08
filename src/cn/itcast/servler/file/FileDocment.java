package cn.itcast.servler.file;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "FileDocment", urlPatterns = "/docment")
public class FileDocment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String path = "D:\\毕业照片\\视频\\电影\\宠物坟场.mkv";
        String[] split = path.split("\\\\");
        String fileName =split[split.length-1];
        FileInputStream fileInputStream = new FileInputStream(path);
        OutputStream outputStream = response.getOutputStream();
        //向客户端发送下载头
        response.setHeader("Content-Disposition", "attachment; filename="+fileName);
        byte[] bytes = new byte[1024*1000];
        int len =0;
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        String url="/index.html";
        response.setStatus(200);
        response.sendRedirect(url);
        fileInputStream.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}