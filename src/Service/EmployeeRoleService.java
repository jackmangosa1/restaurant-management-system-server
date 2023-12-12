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
public interface EmployeeRoleService extends Remote  {
    EmployeeRole recordEmployeeRole(EmployeeRole employeeRoleObj ) throws RemoteException;
    EmployeeRole updateEmployeeRole(EmployeeRole employeeRoleObj ) throws RemoteException;
    EmployeeRole deleteEmployeeRole(EmployeeRole employeeRoleObj ) throws RemoteException;
    EmployeeRole searchEmployeeRole(EmployeeRole employeeRoleObj ) throws RemoteException;
    List<EmployeeRole> allEmployeeRoles() throws RemoteException;
    List<String> allRoleNames() throws RemoteException;
    Integer getRoleIdByName(String roleName) throws RemoteException;
    EmployeeRole getRoleByName(String roleName) throws RemoteException;
}
