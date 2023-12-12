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
public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService {
      public EmployeeServiceImpl() throws RemoteException{
        
    }
    EmployeeDAO dao = new EmployeeDAO();
   @Override
    public Employee recordEmployee(Employee employeeObj) throws RemoteException {
        return dao.registerEmployee(employeeObj);
    }

    @Override
    public Employee updateEmployee(Employee employeeObj) throws RemoteException {
        return dao.updateEmployee(employeeObj);
    }

    @Override
    public Employee deleteEmployee(Employee employeeObj) throws RemoteException {
        return dao.deleteEmployee(employeeObj);
    }

    @Override
    public Employee searchEmployee(Employee employeeObj) throws RemoteException {
        return dao.searchEmployee(employeeObj);
    }

    @Override
    public List<Employee> allEmployees() throws RemoteException {
       return dao.allEmployees();
    }
    
    public  boolean  isUsernameExists(String username) throws RemoteException{
        return dao.isUsernameExists(username);
    }

    @Override
    public Employee getEmployeeByUsername(String username) throws RemoteException {
        return dao.getEmployeeByUsername(username);
    }

    @Override
    public Employee authenticateEmployee(String username, String password) throws RemoteException {
        try {
            Employee employee = dao.getEmployeeByUsername(username);
            if (employee != null && password.equals(employee.getPassword())) {
                return employee; 
            } else {
                return null; 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null; 
        }
    }
   
}
