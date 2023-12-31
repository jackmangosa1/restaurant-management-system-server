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
public class DishCategoryDAO {
      public DishCategory registerDishCategory(DishCategory dishCategoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(dishCategoryObj);
            ss.beginTransaction().commit();
            ss.close();
            return dishCategoryObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public DishCategory updateDishCategory(DishCategory dishCategoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(dishCategoryObj);
            ss.beginTransaction().commit();
            ss.close();
            return dishCategoryObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public DishCategory deleteDishCategory(DishCategory dishCategoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(dishCategoryObj);
            ss.beginTransaction().commit();
            ss.close();
            return dishCategoryObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public DishCategory searchDishCategory(DishCategory dishCategoryToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided DishCategory object
        DishCategory theDishCategory = (DishCategory) ss.get(DishCategory.class, dishCategoryToSearch.getCategoryId());
        ss.close();
        return theDishCategory;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<DishCategory> allDishCategories(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<DishCategory> wareHouses = ss.createQuery("select theDishCategory from  DishCategory theDishCategory").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
