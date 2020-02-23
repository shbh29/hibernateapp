/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author shubham
 */
public class MyHibernateUtil {
    
    private static StandardServiceRegistry registry;

    private static SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            registry = new StandardServiceRegistryBuilder().configure().build();
            
                            // Create MetadataSources

                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata

                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory

                sessionFactory = metadata.getSessionFactoryBuilder().build();
                
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
