package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "rolesId")
private int rolesId;
@Column(name = "rolesName")
@Enumerated(EnumType.STRING)
private ERoles rolesName;

    public Roles() {
    }

    public Roles(int rolesId, ERoles rolesName) {
        this.rolesId = rolesId;
        this.rolesName = rolesName;
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    public ERoles getRolesName() {
        return rolesName;
    }

    public void setRolesName(ERoles rolesName) {
        this.rolesName = rolesName;
    }
}
