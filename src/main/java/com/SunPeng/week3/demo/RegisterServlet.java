package com.SunPeng.week3.demo;

//import javax.servlet.ServletConfig;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    private Object HttpServletRequest;
    private Object IOException;
    private Object HttpServletResponse;
    private Object ServletException;

    public RegisterServlet(Object httpServletRequest, Object ioException, Object httpServletResponse, Object servletException) {
        HttpServletRequest = httpServletRequest;
        IOException = ioException;
        HttpServletResponse = httpServletResponse;
        ServletException = servletException;
    }

    public void init() throws ServletException {

        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        System.out.println(driver);

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
  //      public void init() {
//        ServletContext context=getServletContext();
//
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//        System.out.println(driver);
//
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("init()-->" + con);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }

    //    }

        protected void doPost (HttpServletRequest NashornScriptEngineFactory request;
        request, HttpServletResponse
        HttpServletResponse response;
        response) throws ServletException, IOException {


            con = (Connection) getServletContext().getAttribute("con");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = (String) request.getParameter("email");
            //protected void doPost(HttpServletRequest request, HttpServletResponse response)
            p.setString(5, birthDate);
            p.executeUpdate();
            p.close();
        } catch(SQLException e){
            e.printStackTrace();
        }

        response.setContentType("text/html charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        String sql2 = "select * from usertable ";
        out.println("<table border=\"1\">");
        try {
            PreparedStatement stmt = con.prepareStatement(sql2);
            ResultSet re = stmt.executeQuery();
            while (re.next()) {
                out.println("<tr>");
                out.println("<td>" + re.getInt("id") + "</td>");
                out.println("<td>" + re.getString("username") + "</td>");
                out.println("<td>" + re.getString("password") + "</td>");
                out.println("<td>" + re.getString("email") + "</td>");
                out.println("<td>" + re.getString("gender") + "</td>");
                out.println("<td>" + re.getString("birthdate") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            //PrintWriter out=response.getWriter();
            //String sql2 = "select * from usertable ";
            //here is html code --- move these html code in a jsp page - userList.jsp
//        out.println("<table border=\"1\">");
            //            PreparedStatement stmt = con.prepareStatement(sql2);
//            ResultSet re = stmt.executeQuery();
//            /* while (re.next()) {
//                out.println("<tr>");
//                out.println("<td>"+re.getInt("id")+"</td>");
//                out.println("<td>"+re.getString("username")+"</td>");
//                out.println("<td>"+re.getString("password")+"</td>");
//                out.println("<td>"+re.getString("email")+"</td>");
//                out.println("<td>"+re.getString("gender")+"</td>");
//                out.println("<td>"+re.getString("birthdate")+"</td>");
//                out.println("</tr>");
//            }
//            out.println("</table>");*/
//            request.setAttribute("rename",re);//name - string, value - any type  (objecct)
//            request.getRequestDispatcher("userList.jsp").forward(request,response);//at this point request given to userList.jsp
//            System.out.println("i am in RegisterServlet-->doPost()--> after forward()");//no see this line
            response.sendRedirect("login.jsp");

        } catch (SQLException | java.io.IOException e) {
            e.printStackTrace();
        }

    }}