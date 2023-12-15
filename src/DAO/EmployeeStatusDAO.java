/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.List;
import model.*;
import org.hibernate.Session;
/**
 *
 * @author pc
 */
public class EmployeeStatusDAO {
      public EmployeeStatus registerEmployeeStatus(EmployeeStatus employeeStatusObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(employeeStatusObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeStatusObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public EmployeeStatus updateEmployeeStatus(EmployeeStatus employeeStatusObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(employeeStatusObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeStatusObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public EmployeeStatus deleteEmployeeStatus(EmployeeStatus employeeStatusObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(employeeStatusObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeStatusObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public EmployeeStatus searchEmployeeStatus(EmployeeStatus employeeStatusToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided EmployeeStatus object
        EmployeeStatus theEmployeeStatus = (EmployeeStatus) ss.get(EmployeeStatus.class, employeeStatusToSearch.getStatusId());
        ss.close();
        return theEmployeeStatus;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<EmployeeStatus> allEmployeeStatuses(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<EmployeeStatus> wareHouses = ss.createQuery("select theEmployeeStatus from  EmployeeStatus theEmployeeStatus").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
