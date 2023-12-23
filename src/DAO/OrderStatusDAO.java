/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.OrderStatus;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class OrderStatusDAO {
          public OrderStatus registerOrderStatus(OrderStatus orderStatusObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(orderStatusObj);
            ss.beginTransaction().commit();
            ss.close();
            return orderStatusObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public OrderStatus updateOrderStatus(OrderStatus orderStatusObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(orderStatusObj);
            ss.beginTransaction().commit();
            ss.close();
            return orderStatusObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public OrderStatus deleteOrderStatus(OrderStatus orderStatusObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(orderStatusObj);
            ss.beginTransaction().commit();
            ss.close();
            return orderStatusObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public OrderStatus searchOrderStatus(OrderStatus orderStatusToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided OrderStatus object
        OrderStatus theOrderStatus = (OrderStatus) ss.get(OrderStatus.class, orderStatusToSearch.getStatusId());
        ss.close();
        return theOrderStatus;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<OrderStatus> allOrderStatuses(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<OrderStatus> wareHouses = ss.createQuery("select theOrderStatus from  OrderStatus theOrderStatus").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public OrderStatus getOrderStatusById(int statusId) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();

            // Use the provided statusId to retrieve the OrderStatus
            OrderStatus theOrderStatus = (OrderStatus) ss.get(OrderStatus.class, statusId);

            ss.close();
            return theOrderStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<String> allOrderStatusNames() {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List orderNames = ss.createQuery("select theOrderStatus.statusName from OrderStatus theOrderStatus").list();
        ss.close();
        return (List<String>) orderNames;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public Integer getOrderStatusIdByName(String statusName) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Integer roleId = (Integer) ss.createQuery("select theOrderStatus.statusId from OrderStatus theOrderStatus where theOrderStatus.statusName = :statusName")
                .setParameter("statusName", statusName)
                .uniqueResult();
        ss.close();
        return roleId;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    
    public OrderStatus getOrderStatusByName(String statusName) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();

            OrderStatus theOrderStatus = (OrderStatus) ss.createQuery("select theOrderStatus from OrderStatus theOrderStatus where theOrderStatus.statusName = :statusName")
                    .setParameter("statusName", statusName)
                    .uniqueResult();
            
            ss.close();
            return theOrderStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
