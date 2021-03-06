package com.SunPeng.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //redirect - same server - Relative URL
        //1. start without /
        System.out.println("before redirect");

        //response.sendRedirect("index.jsp");//url - change to index.jsp
        //http://localhost:8080/2019211001001012SunPeng_war_exploded/redirect
        //http://localhost:8080/2019211001001012SunPeng_war_exploded/index.jsp
        //see the url - only last part of url changed (redirect --> index.jsp)

        response.sendRedirect("index.jsp");//url
        System.out.println("after redirect");
        //2. start with /
        response.sendRedirect("/2019211001001012SunPeng_war_exploded/index.jsp");//-???- HTTP Status 404 - Not Found
        //why ? - look at url
        //http://localhost:8080/2019211001001012SunPeng_war_exploded/redirect
        //http://localhost:8080/index.jsp
        //url change after 8080 - means tomcat
        //add /2019211001001012SunPeng_war_exploded/

        //redirect - another server - Absolute URL- full url
        response.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
