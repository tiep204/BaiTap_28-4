package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "department")
    private String department;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Role", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Roles> listRoles = new HashSet<>();


    public Employee() {
    }

    public Employee(int id, String name, String email, String department, Set<Roles> listRoles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.listRoles = listRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<Roles> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<Roles> listRoles) {
        this.listRoles = listRoles;
    }
}
