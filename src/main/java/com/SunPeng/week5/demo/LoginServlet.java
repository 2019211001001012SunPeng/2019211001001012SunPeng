package com.SunPeng.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String sql="Select * from usertable where username=? and password=?";
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps.setString(1,username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps.setString(2,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs= null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(rs.next()){
                out.println("Login Success!!!");
                out.println("Welcome!"+username);
            }
            else {
                out.println("Username or Password Error!!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}