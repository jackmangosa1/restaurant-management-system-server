package Service.implementation;
import Service.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.*;
import DAO.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class OrderStatusServiceImpl extends UnicastRemoteObject implements OrderStatusService {
       public OrderStatusServiceImpl() throws RemoteException{
        
    }
    OrderStatusDAO dao = new OrderStatusDAO();
   @Override
    public OrderStatus recordOrderStatus(OrderStatus orderStatusObj) throws RemoteException {
        return dao.registerOrderStatus(orderStatusObj);
    }

    @Override
    public OrderStatus updateOrderStatus(OrderStatus orderStatusObj) throws RemoteException {
        return dao.updateOrderStatus(orderStatusObj);
    }

    @Override
    public OrderStatus deleteOrderStatus(OrderStatus orderStatusObj) throws RemoteException {
        return dao.deleteOrderStatus(orderStatusObj);
    }

    @Override
    public OrderStatus searchOrderStatus(OrderStatus orderStatusObj) throws RemoteException {
        return dao.searchOrderStatus(orderStatusObj);
    }

    @Override
    public List<OrderStatus> allOrderStatuses() throws RemoteException {
       return dao.allOrderStatuses();
    }

    @Override
    public OrderStatus getOrderStatusById(int statusId) throws RemoteException {
        return dao.getOrderStatusById(statusId);
    }

    @Override
    public List<String> allOrderStatusNames() throws RemoteException {
        return dao.allOrderStatusNames();
    }

    @Override
    public Integer getOrderStatusIdByName(String statusName) throws RemoteException {
        return dao.getOrderStatusIdByName(statusName);
    }

    @Override
    public OrderStatus getOrderStatusByName(String statusName) throws RemoteException {
        return dao.getOrderStatusByName(statusName);
    }
}
