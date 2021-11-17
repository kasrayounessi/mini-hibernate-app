package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee employee = session.get(Employee.class, 1);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<body>");
        out.write("<table>");
        out.write("<thead>");
        out.write("<tr>");
        out.write("<th>Name</th>");
        out.write("<th>Email</th>");
        out.write("<th>Country</th>");
        out.write("</tr>");
        out.write("</thead>");
        out.write("<tbody>");
        out.write("<tr>");
        out.write("<td>"+employee.getName()+"</td>");
        out.write("<td>"+employee.getEmail()+"</td>");
        out.write("<td>"+employee.getCountry()+"</td>");
        out.write("</tr>");
        out.write("</tbody>");
        out.write("</table>");
        out.write("</html>");

        System.out.println(employee.getCountry());

    }

}
