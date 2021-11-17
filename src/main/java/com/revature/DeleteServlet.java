package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("delete from Employee where id = :myId");
        query.setParameter("myId",1);
        int result  = query.executeUpdate();
        t.commit();
        session.close();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("You have attempted to delete an employee");
        out.println("<a href='index.html'>Click to go back</a>");
    }
}
