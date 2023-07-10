package com.example.http;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(new Customer(req.getParameter("id"), req.getParameter("name"), req.getParameter("address")));
           transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        int customerId = Integer.parseInt(req.getParameter("Id"));
        Customer customer = session.get(Customer.class, customerId);
        try {
            session.delete(customer);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        int customerId = Integer.parseInt(req.getParameter("Id"));

        Customer customer = session.get(Customer.class, customerId);

        try {
            String newName = req.getParameter("name");
            String newAddress = req.getParameter("address");

            customer.setName(newName);
            customer.setAddress(newAddress);
            session.saveOrUpdate(customer);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }


}
