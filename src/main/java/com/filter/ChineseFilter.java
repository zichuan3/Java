package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class ChineseFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(request , response);
    }

    public void destroy() {

    }
}
