package com.example.programmeringseksambackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "admin_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminID;

    @Column(name = "admin_name", unique = true)
    private String adminName;

    @Column(name = "admin_password")
    private String adminPassword;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminID.equals(admin.adminID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID);
    }
}
