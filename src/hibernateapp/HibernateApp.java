/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateapp;

import hibernateapp.users.Address;
import hibernateapp.users.User;
import hibernateapp.util.MyHibernateUtil;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author shubham
 */
public class HibernateApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User u1 = new User();//"2", "Sharad Baba", new Date(), "new User Created");
        User u2 = new User();//"2", "Sharad Baba", new Date(), "new User Created");
        Address addr1  = new Address("Airpot Rd","Pune", "MH", 411015);
        Address addr2  = new Address("Dhanori Rd","Pune", "MH", 411014);
//        u1.setId(1);
        u1.setName("Sharad Baba");
        u2.setName("Sharad Baba Dhansu");
        u1.setAddress(addr1);
        u2.setAddress(addr2);
        
        u1.setJoinedDate(new Date());
        u2.setJoinedDate(new Date());
        
        Transaction transaction = null;
        try(Session session = MyHibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.save(u1);
            session.save(u2);
            
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        
//        try(Session session = MyHibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            User user = session.get(User.class, 1);
//            System.out.println(user);
//            transaction.commit();
//        } catch (Exception e) {
//            if(transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
     }
    
}
