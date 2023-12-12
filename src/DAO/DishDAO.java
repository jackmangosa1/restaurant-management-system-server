/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Dish;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class DishDAO {
    public Dish registerDish(Dish dishObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(dishObj);
            ss.beginTransaction().commit();
            ss.close();
            return dishObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public Dish updateDish(Dish dishObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(dishObj);
            ss.beginTransaction().commit();
            ss.close();
            return dishObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    public Dish deleteDish(Dish dishObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(dishObj);
            ss.beginTransaction().commit();
            ss.close();
            return dishObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        
    }
   public Dish searchDish(Dish dishToSearch) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use the ID from the provided Dish object
        Dish theDish = (Dish) ss.get(Dish.class, dishToSearch.getDishId());
        ss.close();
        return theDish;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    public List<Dish> allDishes(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Dish> wareHouses = ss.createQuery("select theDish from  Dish theDish").list();
            ss.close();
            return wareHouses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
