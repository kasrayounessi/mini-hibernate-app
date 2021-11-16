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

public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setCountry(request.getParameter("country"));

        session.save(employee);
        t.commit();
        session.close();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("You have attempted to sign in an employee");
        out.println("<a href='index.html'>Click to go back</a>");

    }
}
