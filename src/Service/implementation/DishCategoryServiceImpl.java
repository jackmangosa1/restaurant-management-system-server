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
public class DishCategoryServiceImpl extends UnicastRemoteObject implements DishCategoryService {
     public DishCategoryServiceImpl() throws RemoteException{
        
    }
    DishCategoryDAO dao = new DishCategoryDAO();
   @Override
    public DishCategory recordDishCategory(DishCategory dishCategoryObj) throws RemoteException {
        return dao.registerDishCategory(dishCategoryObj);
    }

    @Override
    public DishCategory updateDishCategory(DishCategory dishCategoryObj) throws RemoteException {
        return dao.updateDishCategory(dishCategoryObj);
    }

    @Override
    public DishCategory deleteDishCategory(DishCategory dishCategoryObj) throws RemoteException {
        return dao.deleteDishCategory(dishCategoryObj);
    }

    @Override
    public DishCategory searchDishCategory(DishCategory dishCategoryObj) throws RemoteException {
        return dao.searchDishCategory(dishCategoryObj);
    }

    @Override
    public List<DishCategory> allDishCategories() throws RemoteException {
       return dao.allDishCategories();
    }
}
