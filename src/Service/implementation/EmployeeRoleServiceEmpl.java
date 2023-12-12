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
public class EmployeeRoleServiceEmpl extends UnicastRemoteObject implements EmployeeRoleService {
     public EmployeeRoleServiceEmpl() throws RemoteException{
        
    }
    EmployeeRoleDAO dao = new EmployeeRoleDAO();
   @Override
    public EmployeeRole recordEmployeeRole(EmployeeRole employeeRoleObj) throws RemoteException {
        return dao.registerEmployeeRole(employeeRoleObj);
    }

    @Override
    public EmployeeRole updateEmployeeRole(EmployeeRole employeeRoleObj) throws RemoteException {
        return dao.updateEmployeeRole(employeeRoleObj);
    }

    @Override
    public EmployeeRole deleteEmployeeRole(EmployeeRole employeeRoleObj) throws RemoteException {
        return dao.deleteEmployeeRole(employeeRoleObj);
    }

    @Override
    public EmployeeRole searchEmployeeRole(EmployeeRole employeeRoleObj) throws RemoteException {
        return dao.searchEmployeeRole(employeeRoleObj);
    }

    @Override
    public List<EmployeeRole> allEmployeeRoles() throws RemoteException {
       return dao.allEmployeeRoles();
    }

    @Override
    public List<String> allRoleNames() throws RemoteException {
        return dao.allRoleNames();
    }

    @Override
    public Integer getRoleIdByName(String roleName) throws RemoteException {
        return dao.getRoleIdByName(roleName);
}

    @Override
    public EmployeeRole getRoleByName(String roleName) throws RemoteException {
        return dao.getRoleByName(roleName);
    }
}
    
