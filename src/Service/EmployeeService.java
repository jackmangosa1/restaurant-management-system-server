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
public interface EmployeeService extends Remote {
   Employee recordEmployee(Employee employeeObj ) throws RemoteException;
   Employee updateEmployee(Employee employeeObj ) throws RemoteException;
   Employee deleteEmployee(Employee employeeObj ) throws RemoteException;
   Employee searchEmployee(Employee employeeObj ) throws RemoteException;
   List<Employee> allEmployees() throws RemoteException;
   boolean isUsernameExists(String username) throws RemoteException;
   Employee getEmployeeByUsername(String username) throws RemoteException;
   Employee authenticateEmployee(String username, String password) throws RemoteException;
}
