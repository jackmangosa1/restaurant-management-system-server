/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
/**
 *
 * @author pc
 */
@Entity
@Table(name = "role")
public class EmployeeRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    private String roleName;
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmployeeRole other = (EmployeeRole) obj;
        return roleId == other.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }

    public EmployeeRole() {
    }

    public EmployeeRole(int roleId) {
        this.roleId = roleId;
    }

    public EmployeeRole(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    

  
    
}
