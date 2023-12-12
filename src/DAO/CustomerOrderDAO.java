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
public class CustomerOrderDAO {
      public CustomerOrder registerCustomerOrder(CustomerOrder customerOrderObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(customerOrderObj);
            ss.beginTransaction().commit();
            ss.close();
            return customerOrderObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public CustomerOrder updateCustomerOrder(CustomerOrder customerOrderObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(customerOrderObj);
            ss.beginTransaction().commit();
            ss.close();
            return customerOrderObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public CustomerOrder deleteCustomerOrder(CustomerOrder customerOrderObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(customerOrderObj);
            ss.beginTransaction().commit();
            ss.close();
            return customerOrderObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public CustomerOrder searchCustomerOrder(CustomerOrder customerOrderToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided CustomerOrder object
        CustomerOrder theCustomerOrder = (CustomerOrder) ss.get(CustomerOrder.class, customerOrderToSearch.getOrderId());
        ss.close();
        return theCustomerOrder;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<CustomerOrder> allCustomerOrders(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<CustomerOrder> wareHouses = ss.createQuery("select theCustomerOrder from  CustomerOrder theCustomerOrder").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
