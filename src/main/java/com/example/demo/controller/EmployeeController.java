package com.example.demo.controller;

import com.example.demo.dto.request.EmployeeRequest;
import com.example.demo.model.entity.Employee;
import com.example.demo.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public List<Employee> employeeList() {
        return employeeService.getAll();
    }

    @PostMapping()
    public String createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            return employeeService.create(employeeRequest);
        } catch (IllegalArgumentException e) {
            return "Role không hợp lệ";
        }
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest) {
        /*  try {*/
        employeeRequest.setId(id);
        return employeeService.update(employeeRequest);
        /* return ResponseEntity.ok("bạn đã cập nhật thành công");*/
     /*   }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("bạn cập nhật không thành công");
        }*/


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return ResponseEntity.ok("bạn đã xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("bạn xóa không thành công");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEployeeById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(employeeService.getEmployById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("id không tồn tại");
        }
    }
}
