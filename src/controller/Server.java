/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Service.implementation.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author pc
 */
public class Server {
    public static void main(String[] args) {
         try{
            // set Properties
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            // create Registry
            Registry theRegistry = LocateRegistry.createRegistry(6000);
            theRegistry.rebind("customer", new CustomerServiceImpl());
            theRegistry.rebind("order",new CustomerOrderServiceImpl());
            theRegistry.rebind("category", new DishCategoryServiceImpl());
            theRegistry.rebind("dish",new DishServiceImpl());
            theRegistry.rebind("role", new EmployeeRoleServiceEmpl());
            theRegistry.rebind("employee",new   EmployeeServiceImpl());
            theRegistry.rebind("orderItem", new OrderItemServiceImpl());
            theRegistry.rebind("orderSatus",new OrderStatusServiceImpl());
            System.out.println("Server is running on port 6000");
             Thread.currentThread().join();
    }catch(Exception ex){
        ex.printStackTrace();
    }
    }
}
