/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.List;
import model.*;
import org.hibernate.*;
/**
 *
 * @author pc
 */
public class EmployeeDAO {
    public Employee registerEmployee(Employee employeeObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(employeeObj);
            System.out.println("Database operation successful");
            ss.beginTransaction().commit();
            ss.close();
            return employeeObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public Employee updateEmployee(Employee employeeObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(employeeObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public Employee deleteEmployee(Employee employeeObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(employeeObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public Employee searchEmployee(Employee employeeToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided Employee object
        Employee theEmployee = (Employee) ss.get(Employee.class, employeeToSearch.getEmployeeId());
        ss.close();
        return theEmployee;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<Employee> allEmployees(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Employee> wareHouses = ss.createQuery("select theEmployee from  Employee theEmployee").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public boolean isUsernameExists(String username) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Query query = ss.createQuery("SELECT COUNT(*) FROM Employee WHERE username = :username");
            query.setParameter("username", username);
            Long count = (Long) query.uniqueResult();

            ss.close();
            return count > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; 
        }
     }
     
     public Employee getEmployeeByUsername(String username) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Employee WHERE username = :username";
        Query query = ss.createQuery(hql);
        query.setParameter("username", username);
        Employee result = (Employee) query.uniqueResult(); 
        ss.close();
        return result; 
    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }
}
}
