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
public class EmployeeStatusServiceImpl extends UnicastRemoteObject implements EmployeeStatusService {
          public EmployeeStatusServiceImpl() throws RemoteException{
        
    }
    EmployeeStatusDAO dao = new EmployeeStatusDAO();
   @Override
    public EmployeeStatus recordEmployeeStatus(EmployeeStatus employeeStatusObj) throws RemoteException {
        return dao.registerEmployeeStatus(employeeStatusObj);
    }

    @Override
    public EmployeeStatus updateEmployeeStatus(EmployeeStatus employeeStatusObj) throws RemoteException {
        return dao.updateEmployeeStatus(employeeStatusObj);
    }

    @Override
    public EmployeeStatus deleteEmployeeStatus(EmployeeStatus employeeStatusObj) throws RemoteException {
        return dao.deleteEmployeeStatus(employeeStatusObj);
    }

    @Override
    public EmployeeStatus searchEmployeeStatus(EmployeeStatus employeeStatusObj) throws RemoteException {
        return dao.searchEmployeeStatus(employeeStatusObj);
    }

    @Override
    public List<EmployeeStatus> allEmployeeStatuses() throws RemoteException {
       return dao.allEmployeeStatuses();
    }

   
}
