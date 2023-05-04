package com.example.demo.model.service;

import com.example.demo.model.entity.ERoles;
import com.example.demo.model.entity.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByRolesName(ERoles roleName);

}
