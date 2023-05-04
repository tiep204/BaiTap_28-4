package com.example.demo.model.serviceImp;

import com.example.demo.Respository.EmployeeRespository;
import com.example.demo.Respository.RoleRepository;
import com.example.demo.dto.request.EmployeeRequest;
import com.example.demo.model.entity.ERoles;
import com.example.demo.model.entity.Employee;
import com.example.demo.model.entity.Roles;
import com.example.demo.model.service.EmployeeService;
import com.example.demo.model.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRespository employeeRespository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public String create(EmployeeRequest employeeRequest) {
        if (employeeRespository.findByEmail(employeeRequest.getEmail())!=null) {
            return "Email đã tồn tại";
        }
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartment(employeeRequest.getDepartment());
        Set<String> strRole = employeeRequest.getListRoles();
        Set<Roles> listRoles = new HashSet<>();
        if (strRole == null) {
            Roles roless = roleRepository.findByRolesName(ERoles.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            listRoles.add(roless);
        } else {
            strRole.forEach(role -> {
                switch (role) {
                    case "admin":
                        Roles adminRole = roleRepository.findByRolesName(ERoles.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        listRoles.add(adminRole);
                        break;
                    case "user":
                        Roles userRole = roleRepository.findByRolesName(ERoles.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        listRoles.add(userRole);
                        break;
                    default:
                        throw new IllegalArgumentException("Role không hợp lệ");


                }
            });
        }

        employee.setListRoles(listRoles);
        try {
            employeeRespository.save(employee);
            return "thêm mới thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "thêm mới nhân viên không thành công";
        }
    }


    @Override
    public String update(EmployeeRequest emloyeeRequest) {
        Optional<Employee> optionalEmployee = employeeRespository.findById(emloyeeRequest.getId());
        if (!optionalEmployee.isPresent()) {
            return "Id không tồn tại";
        }

        Employee emloyee = optionalEmployee.get();
        emloyee.setName(emloyeeRequest.getName());
        if (employeeRespository.findByEmail(emloyeeRequest.getEmail())==null||emloyeeRequest.getEmail()==emloyeeRequest.getEmail()) {
            emloyee.setEmail(emloyeeRequest.getEmail());
        }else {
            return "email đã tồn tại";
        }
        emloyee.setDepartment(emloyeeRequest.getDepartment());

        try {
            employeeRespository.save(emloyee);
            return "Update thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update không thành công";
        }

    }

    @Override
    public void delete(int id) {
        if (id >= 1) {
            Optional<Employee> employeeOptional = employeeRespository.findById(id);
            Employee employee = employeeOptional.get();
            if (employeeOptional.isPresent()) {
                employeeRespository.delete(employee);
            } else {
                throw new RuntimeException("ID không tồn tại");
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee getEmployById(int id) {
        Optional<Employee> employeeOptional = employeeRespository.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new RuntimeException("ID không tồn tại");
        }
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRespository.findByEmail(email);
    }
}
