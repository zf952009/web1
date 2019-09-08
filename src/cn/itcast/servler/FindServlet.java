package cn.itcast.servler;

import cn.itcast.data.Product;
import cn.itcast.data.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindServlet", urlPatterns = "/FindServlet")
public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //当前页码
        int currPage = 1;
        if (request.getParameter("page")!=null){
            currPage = Integer.parseInt(request.getParameter("page"));
        }
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.find(currPage);
        request.setAttribute("list",productDao);

        //总页数
        int pages;
        //查询记录数
        int count = productDao.findCount();
        if (count%Product.PAGE_SIZE==0){
            pages = count/Product.PAGE_SIZE;
        }else {
            pages = count/Product.PAGE_SIZE+1;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i=1;i<=pages;i++){
            if (i==currPage){
                stringBuffer.append("["+i+"]");
            }else{
                //构建分页条
                stringBuffer.append("<a href=/JavaWeb/FindServlet?page="+i+"/>"+i+"</a>");
            }
            stringBuffer.append("  ");
            //将分页条的字符串放置到request中
            request.setAttribute("bar",stringBuffer.toString());
            //页面转发到数据显示页面
            request.getRequestDispatcher("product_list.jsp").forward(request,response);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}