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
public class DishServiceImpl extends UnicastRemoteObject implements DishService {
      public DishServiceImpl() throws RemoteException{
        
    }
    DishDAO dao = new DishDAO();
   @Override
    public Dish recordDish(Dish dishObj) throws RemoteException {
        return dao.registerDish(dishObj);
    }

    @Override
    public Dish updateDish(Dish dishObj) throws RemoteException {
        return dao.updateDish(dishObj);
    }

    @Override
    public Dish deleteDish(Dish dishObj) throws RemoteException {
        return dao.deleteDish(dishObj);
    }

    @Override
    public Dish searchDish(Dish dishObj) throws RemoteException {
        return dao.searchDish(dishObj);
    }

    @Override
    public List<Dish> allDishes() throws RemoteException {
       return dao.allDishes();
    }
}
