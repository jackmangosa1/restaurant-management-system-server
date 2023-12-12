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
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {
       public CustomerServiceImpl() throws RemoteException{
        
    }
    CustomerDAO dao = new CustomerDAO();
   @Override
    public Customer recordCustomer(Customer customerObj) throws RemoteException {
        return dao.registerCustomer(customerObj);
    }

    @Override
    public Customer updateCustomer(Customer customerObj) throws RemoteException {
        return dao.updateCustomer(customerObj);
    }

    @Override
    public Customer deleteCustomer(Customer customerObj) throws RemoteException {
        return dao.deleteCustomer(customerObj);
    }

    @Override
    public Customer searchCustomer(Customer customerObj) throws RemoteException {
        return dao.searchCustomer(customerObj);
    }

    @Override
    public List<Customer> allCustomers() throws RemoteException {
       return dao.allCustomers();
    }
}
