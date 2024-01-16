/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.Date;
import java.util.List;
import model.*;
import org.hibernate.*;
import org.hibernate.type.StandardBasicTypes;
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
    
   
      
    public double getTotalSalesForToday() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();

            Date today = new Date();
            Query query = ss.createQuery("SELECT SUM(co.totalAmount) FROM CustomerOrder co WHERE co.orderDate = :today");
            query.setParameter("today", today);

            Double totalSales = (Double) query.uniqueResult();
            ss.close();

            return totalSales != null ? totalSales : 0.0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }
    
     public int getTotalReceivedOrders() {
        return getTotalOrdersByStatus(1); // 1 is the ID for "received"
    }

    public int getTotalCookingOrders() {
        return getTotalOrdersByStatus(2); // 2 is the ID for "cooking"
    }

    public int getTotalCompletedOrders() {
        return getTotalOrdersByStatus(3); // 3 is the ID for "completed"
    }

    public int getTotalDeliveredOrders() {
        return getTotalOrdersByStatus(4); // 4 is the ID for "delivered"
    }

    private int getTotalOrdersByStatus(int statusId) {
        try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        Date today = new Date();
        Query query = ss.createQuery("SELECT COUNT(co) FROM CustomerOrder co WHERE co.status.statusId = :statusId AND co.orderDate = :today");
        query.setParameter("statusId", statusId);
        query.setParameter("today", today);

        Long totalOrders = (Long) query.uniqueResult();
        ss.close();

        return totalOrders != null ? totalOrders.intValue() : 0;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return 0;
  }
}
