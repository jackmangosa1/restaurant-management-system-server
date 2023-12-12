/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.EmployeeRole;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class EmployeeRoleDAO {
      public EmployeeRole registerEmployeeRole(EmployeeRole employeeRoleObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(employeeRoleObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeRoleObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public EmployeeRole updateEmployeeRole(EmployeeRole employeeRoleObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(employeeRoleObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeRoleObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public EmployeeRole deleteEmployeeRole(EmployeeRole employeeRoleObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(employeeRoleObj);
            ss.beginTransaction().commit();
            ss.close();
            return employeeRoleObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public EmployeeRole searchEmployeeRole(EmployeeRole employeeRoleToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided EmployeeRole object
        EmployeeRole theEmployeeRole = (EmployeeRole) ss.get(EmployeeRole.class, employeeRoleToSearch.getRoleId());
        ss.close();
        return theEmployeeRole;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<EmployeeRole> allEmployeeRoles(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<EmployeeRole> wareHouses = ss.createQuery("select theEmployeeRole from  EmployeeRole theEmployeeRole").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<String> allRoleNames() {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List roleNames = ss.createQuery("select theEmployeeRole.roleName from EmployeeRole theEmployeeRole").list();
        ss.close();
        return (List<String>) roleNames;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public Integer getRoleIdByName(String roleName) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Integer roleId = (Integer) ss.createQuery("select theEmployeeRole.roleId from EmployeeRole theEmployeeRole where theEmployeeRole.roleName = :roleName")
                .setParameter("roleName", roleName)
                .uniqueResult();
        ss.close();
        return roleId;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    
    public EmployeeRole getRoleByName(String roleName) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();

            EmployeeRole theEmployeeRole = (EmployeeRole) ss.createQuery("select theEmployeeRole from EmployeeRole theEmployeeRole where theEmployeeRole.roleName = :roleName")
                    .setParameter("roleName", roleName)
                    .uniqueResult();
            
            ss.close();
            return theEmployeeRole;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
