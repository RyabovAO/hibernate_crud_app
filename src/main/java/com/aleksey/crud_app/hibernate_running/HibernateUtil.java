package com.aleksey.crud_app.hibernate_running;

import com.aleksey.crud_app.model.Label;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {

        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
