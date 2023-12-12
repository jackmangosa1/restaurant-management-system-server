/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.OrderItem;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class OrderItemDAO {
       public OrderItem registerOrderItem(OrderItem orderItemObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(orderItemObj);
            ss.beginTransaction().commit();
            ss.close();
            return orderItemObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public OrderItem updateOrderItem(OrderItem orderItemObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(orderItemObj);
            ss.beginTransaction().commit();
            ss.close();
            return orderItemObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public OrderItem deleteOrderItem(OrderItem orderItemObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(orderItemObj);
            ss.beginTransaction().commit();
            ss.close();
            return orderItemObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public OrderItem searchOrderItem(OrderItem orderItemToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided OrderItem object
        OrderItem theOrderItem = (OrderItem) ss.get(OrderItem.class, orderItemToSearch.getOrderItemId());
        ss.close();
        return theOrderItem;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<OrderItem> allOrderItems(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<OrderItem> wareHouses = ss.createQuery("select theOrderItem from  OrderItem theOrderItem").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
