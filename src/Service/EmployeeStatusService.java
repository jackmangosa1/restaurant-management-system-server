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
public interface EmployeeStatusService extends Remote{
    EmployeeStatus recordEmployeeStatus(EmployeeStatus employeeStatusObj ) throws RemoteException;
    EmployeeStatus updateEmployeeStatus(EmployeeStatus employeeStatusObj ) throws RemoteException;
    EmployeeStatus deleteEmployeeStatus(EmployeeStatus employeeStatusObj ) throws RemoteException;
    EmployeeStatus searchEmployeeStatus(EmployeeStatus employeeStatusObj ) throws RemoteException;
    List<EmployeeStatus> allEmployeeStatuses() throws RemoteException;
    List<String> allEmployeeStatusNames() throws RemoteException;
    Integer getEmployeeStatusIdByName(String statusName) throws RemoteException;
    EmployeeStatus getEmployeeStatusByName(String statusName) throws RemoteException;
    
}
