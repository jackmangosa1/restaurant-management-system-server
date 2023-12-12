/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "Order_status")
public class OrderStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusId;
    @Column(name = "status_name")
    private String statusName;
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<CustomerOrder> orderStatus =  new ArrayList<>();

    public OrderStatus() {
    }

    public OrderStatus(int statusId) {
        this.statusId = statusId;
    }

    public OrderStatus(int statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<CustomerOrder> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<CustomerOrder> orderStatus) {
        this.orderStatus = orderStatus;
    }
    

}
