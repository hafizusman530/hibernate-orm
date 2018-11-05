package com.usman.practice.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //    Session uses SessionFactory, which contains database configuration. if your app have multiple DBs you need
//    to have configure multiple sessionFactory instances for each database. SessionFactory is thread safe.
    private static SessionFactory sessionFactory;

    static {
        loadSessionFactory();
    }

    private static void loadSessionFactory() {
        sessionFactory = new Configuration()
                .configure().buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
