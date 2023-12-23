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
public interface CustomerOrderService extends Remote{
    CustomerOrder recordCustomerOrder(CustomerOrder customerOrderObj ) throws RemoteException;
    CustomerOrder updateCustomerOrder(CustomerOrder customerOrderObj ) throws RemoteException;
    CustomerOrder deleteCustomerOrder(CustomerOrder customerOrderObj ) throws RemoteException;
    CustomerOrder searchCustomerOrder(CustomerOrder customerOrderObj ) throws RemoteException;
    List<CustomerOrder> allCustomerOrders() throws RemoteException;
    double getTotalSalesForToday()throws RemoteException; 
    int getTotalReceivedOrders() throws RemoteException; 
    int getTotalCookingOrders() throws RemoteException; 
    int getTotalCompletedOrders() throws RemoteException;
    int getTotalDeliveredOrders()  throws RemoteException;
}
