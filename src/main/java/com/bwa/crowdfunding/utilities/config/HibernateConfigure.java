package com.bwa.crowdfunding.utilities.config;

import com.bwa.crowdfunding.entity.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfigure {

    private static final SessionFactory ourSessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {

            MetadataSources metadataSources = new MetadataSources(registry);

            metadataSources.addAnnotatedClass(Users.class);

            ourSessionFactory = metadataSources
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (Throwable e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError(e);
        }
    }

    // access singletone
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

}
