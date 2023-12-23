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
public class CustomerOrderServiceImpl extends UnicastRemoteObject implements CustomerOrderService {
    public CustomerOrderServiceImpl() throws RemoteException{
        
    }
    CustomerOrderDAO dao = new CustomerOrderDAO();
   @Override
    public CustomerOrder recordCustomerOrder(CustomerOrder customerOrderObj) throws RemoteException {
        return dao.registerCustomerOrder(customerOrderObj);
    }

    @Override
    public CustomerOrder updateCustomerOrder(CustomerOrder customerOrderObj) throws RemoteException {
        return dao.updateCustomerOrder(customerOrderObj);
    }

    @Override
    public CustomerOrder deleteCustomerOrder(CustomerOrder customerOrderObj) throws RemoteException {
        return dao.deleteCustomerOrder(customerOrderObj);
    }

    @Override
    public CustomerOrder searchCustomerOrder(CustomerOrder customerOrderObj) throws RemoteException {
        return dao.searchCustomerOrder(customerOrderObj);
    }

    @Override
    public List<CustomerOrder> allCustomerOrders() throws RemoteException {
       return dao.allCustomerOrders();
    }

    @Override
    public double getTotalSalesForToday() throws RemoteException {
       return dao.getTotalSalesForToday();
    }

    @Override
    public int getTotalReceivedOrders() throws RemoteException {
        return dao.getTotalReceivedOrders();
    }

    @Override
    public int getTotalCookingOrders() throws RemoteException {
        return dao.getTotalCookingOrders();
    }

    @Override
    public int getTotalCompletedOrders() throws RemoteException {
        return dao.getTotalCompletedOrders();
    }

    @Override
    public int getTotalDeliveredOrders() throws RemoteException {
       return dao.getTotalDeliveredOrders();
    }

    
    
}
