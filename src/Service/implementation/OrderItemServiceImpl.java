/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.implementation;
import Service.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.*;
import DAO.*;
/**
 *
 * @author pc
 */
public class OrderItemServiceImpl extends UnicastRemoteObject implements OrderItemService {
      public OrderItemServiceImpl() throws RemoteException{
        
    }
    OrderItemDAO dao = new OrderItemDAO();
   @Override
    public OrderItem recordOrderItem(OrderItem orderItemObj) throws RemoteException {
        return dao.registerOrderItem(orderItemObj);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItemObj) throws RemoteException {
        return dao.updateOrderItem(orderItemObj);
    }

    @Override
    public OrderItem deleteOrderItem(OrderItem orderItemObj) throws RemoteException {
        return dao.deleteOrderItem(orderItemObj);
    }

    @Override
    public OrderItem searchOrderItem(OrderItem orderItemObj) throws RemoteException {
        return dao.searchOrderItem(orderItemObj);
    }

    @Override
    public List<OrderItem> allOrderItems() throws RemoteException {
       return dao.allOrderItems();
    }
}
