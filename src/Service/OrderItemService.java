/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.*;
/**
 *
 * @author pc
 */
public interface OrderItemService extends Remote{
   OrderItem recordOrderItem(OrderItem orderItemObj ) throws RemoteException;
   OrderItem updateOrderItem(OrderItem orderItemObj ) throws RemoteException;
   OrderItem deleteOrderItem(OrderItem orderItemObj ) throws RemoteException;
   OrderItem searchOrderItem(OrderItem orderItemObj ) throws RemoteException;
   List<OrderItem> allOrderItems() throws RemoteException;
   List<OrderItem> getOrderItemsByOrderId(int orderId) throws RemoteException; 
}
