/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
/**
 *
 * @author pc
 */
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
     @Column(name = "last_name")
    private String lastName;
    @ManyToMany
    @JoinTable(
        name = "employee_role",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<EmployeeRole> roles =  new HashSet<>();
    @OneToMany(mappedBy = "cashier", cascade = CascadeType.ALL)
    private List<CustomerOrder> orders  = new ArrayList<>();
    private String username;
    private String password;
    Boolean isActive = true;

    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(Integer employeeId, String firstName, String lastName, String username, String password) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<EmployeeRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<EmployeeRole> roles) {
        this.roles = roles;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

  
    
}
