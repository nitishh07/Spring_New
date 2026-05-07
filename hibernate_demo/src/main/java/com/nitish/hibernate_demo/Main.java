package com.nitish.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        a1.setAid(103);
        a1.setAname("Pihu");
        a1.setTech("Java");

        //hey hibernate save with a1 object
        Configuration config = new Configuration();  //“Hibernate ko ready karo.”
        config.addAnnotatedClass(Alien.class);
        config.configure();
        
        SessionFactory factory = config.buildSessionFactory(); //Ye database connection factory hai.
        Session session = factory.openSession(); //Session = database ke saath live connection.

        // Transaction transaction = session.beginTransaction();
        System.out.println("Running...");
        //to add
        // session.persist(a1);

        //to fetch data
        session.get(Alien.class , 103);

        System.out.println(a1);

        // transaction.commit();

        session.close();
        factory.close();
    }
}
 