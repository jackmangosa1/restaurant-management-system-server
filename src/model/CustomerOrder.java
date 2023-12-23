/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author pc
 */
@Entity
@Table(name = "Customer_order")
public class CustomerOrder implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    @Column(name = "order_date", columnDefinition = "DATE")
    private Date orderDate;
    private double totalAmount;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "cashier_id")
    private Employee cashier;

    public CustomerOrder() {
    }

    public CustomerOrder(int orderId) {
        this.orderId = orderId;
    }

    public CustomerOrder(int orderId, Customer customer, List<OrderItem> orderItems, Date orderDate, double totalAmount, OrderStatus status, Employee cashier) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.cashier = cashier;
    }
    
    public CustomerOrder(Customer customer, List<OrderItem> orderItems, Date orderDate, double totalAmount, OrderStatus status, Employee cashier) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.cashier = cashier;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    
}
