package filter;

import javax.servlet.*;
import java.io.IOException;

public class Myfilter implements Filter {
    //字符编码
    String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encoding != null) {
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setCharacterEncoding(encoding);
            servletResponse.setContentType("text/html;charset=" + encoding);
        }
        //传递给下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}