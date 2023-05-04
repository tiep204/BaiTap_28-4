package com.example.demo.Respository;

import com.example.demo.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee,Integer> {

Employee findByEmail(String email);



}
