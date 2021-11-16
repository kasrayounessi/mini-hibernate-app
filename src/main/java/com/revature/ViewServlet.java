package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.http.HttpServlet;

public class ViewServlet extends HttpServlet {

    public void doGet(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee employee = session.get(Employee.class, 1);
        System.out.println(employee);

    }

}
