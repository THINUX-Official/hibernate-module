package util;

/*
    @author THINUX
    @created 18-Mar-23 - 08:44 
*/

import entity.Customer;
import entity.Laptop;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                /*.addAnnotatedClass(Customer.class)*/
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
