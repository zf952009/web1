package cn.itcast.servler;

import cn.itcast.data.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateBook", urlPatterns = "/UpdateBook")
public class UpdateBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //数据提交方法，get post
        String meoth = request.getMethod();
        if ("GET".equals(meoth)){
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = BookDateUtils.delete_tb_book(id);
            response.getWriter().write(request+"");
            response.sendRedirect("/JavaWeb/BookFind");
        }
        if ("POST".equals(meoth)){
            Book book = new Book();
            book.setId(Integer.parseInt(request.getParameter("id")));
            book.setName(request.getParameter("name"));
            book.setPrice(Double.parseDouble(request.getParameter("price")));
            book.setBookCount(Integer.parseInt(request.getParameter("bookCount")));
            book.setAuthor(request.getParameter("author"));
            boolean result = BookDateUtils.update_tb_book(book);
            response.getWriter().write(result+"");
            response.sendRedirect("/JavaWeb/BookFind");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    public void init() throws ServletException {

    }

}