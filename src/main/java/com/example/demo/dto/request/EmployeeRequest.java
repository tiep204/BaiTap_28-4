package com.example.demo.dto.request;

import java.util.List;
import java.util.Set;

public class EmployeeRequest {
private int id;
private String name;
private String email;
private String department;
private Set<String> listRoles;

    public EmployeeRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeRequest(int id, String name, String email, String department, Set<String> listRoles) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<String> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<String> listRoles) {
        this.listRoles = listRoles;
    }
}
