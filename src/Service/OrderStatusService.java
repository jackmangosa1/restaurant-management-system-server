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
public interface OrderStatusService extends Remote{
   OrderStatus recordOrderStatus(OrderStatus orderStatusObj ) throws RemoteException;
   OrderStatus updateOrderStatus(OrderStatus orderStatusObj ) throws RemoteException;
   OrderStatus deleteOrderStatus(OrderStatus orderStatusObj ) throws RemoteException;
   OrderStatus searchOrderStatus(OrderStatus orderStatusObj ) throws RemoteException;
   List<OrderStatus> allOrderStatuses() throws RemoteException;
   OrderStatus getOrderStatusById(int statusId) throws RemoteException;
}
