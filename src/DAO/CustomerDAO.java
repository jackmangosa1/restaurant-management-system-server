/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.List;
import model.*;
import org.hibernate.*;

/**
 *
 * @author pc
 */
public class CustomerDAO {
    public Customer registerCustomer(Customer customerObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(customerObj);
            ss.beginTransaction().commit();
            ss.close();
            return customerObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public Customer updateCustomer(Customer customerObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(customerObj);
            ss.beginTransaction().commit();
            ss.close();
            return customerObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public Customer deleteCustomer(Customer customerObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(customerObj);
            ss.beginTransaction().commit();
            ss.close();
            return customerObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public Customer searchCustomer(Customer customerToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided Customer object
        Customer theCustomer = (Customer) ss.get(Customer.class, customerToSearch.getCustomerId());
        ss.close();
        return theCustomer;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<Customer> allCustomers(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Customer> wareHouses = ss.createQuery("select theCustomer from  Customer theCustomer").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public boolean isPhoneNumberExists(String phoneNumber) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Query query = ss.createQuery("SELECT COUNT(*) FROM Customer WHERE telephoneNumber = :phoneNumber");
            query.setParameter("phoneNumber", phoneNumber);
            Long count = (Long) query.uniqueResult();

            ss.close();
            return count > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
