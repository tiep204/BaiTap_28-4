package com.example.demo.model.service;

import com.example.demo.dto.request.EmployeeRequest;
import com.example.demo.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
String create(EmployeeRequest employeeRequest);
String update(EmployeeRequest employeeRequest);
void delete(int id);
List<Employee> getAll();
Employee getEmployById(int id);
    Employee findByEmail(String email);
}
