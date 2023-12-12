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
public interface DishService extends Remote {
    Dish recordDish(Dish dishObj ) throws RemoteException;
    Dish updateDish(Dish dishObj ) throws RemoteException;
    Dish deleteDish(Dish dishObj ) throws RemoteException;
    Dish searchDish(Dish dishObj ) throws RemoteException;
    List<Dish> allDishes() throws RemoteException;
}
