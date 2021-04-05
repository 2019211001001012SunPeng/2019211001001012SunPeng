package com.SunPeng.week4.demo;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/register")

public class RegisterServlet1 extends HttpServlet {
    Connection con = null;

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

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthdate");
        System.out.println(birthDate);
        String sql1 = "Insert into usertable(username,password,email,gender,birthdate) values(?,?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql1);
            p.setString(1,username);
            p.setString(2,password);
            p.setString(3,email);
            p.setString(4,gender);
            p.setString(5,birthDate);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html charset=utf-8");
        PrintWriter out=response.getWriter();
        String sql2 = "select * from usertable ";
        out.println("<table border=\"1\">");
        try {
            PreparedStatement stmt = con.prepareStatement(sql2);
            ResultSet re = stmt.executeQuery();
            while (re.next()) {
                out.println("<tr>");
                out.println("<td>"+re.getInt("id")+"</td>");
                out.println("<td>"+re.getString("username")+"</td>");
                out.println("<td>"+re.getString("password")+"</td>");
                out.println("<td>"+re.getString("email")+"</td>");
                out.println("<td>"+re.getString("gender")+"</td>");
                out.println("<td>"+re.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}