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
public interface DishCategoryService extends Remote{
    DishCategory recordDishCategory(DishCategory dishcategoryObj ) throws RemoteException;
    DishCategory updateDishCategory(DishCategory dishcategoryObj ) throws RemoteException;
    DishCategory deleteDishCategory(DishCategory dishcategoryObj ) throws RemoteException;
    DishCategory searchDishCategory(DishCategory dishcategoryObj ) throws RemoteException;
    List<DishCategory> allDishCategories() throws RemoteException;
    List<String> allCategoryNames()throws RemoteException;
    Integer getCategoryIdByName(String categoryName)throws RemoteException;
    DishCategory getCategoryByName(String categoryName)throws RemoteException;
}
