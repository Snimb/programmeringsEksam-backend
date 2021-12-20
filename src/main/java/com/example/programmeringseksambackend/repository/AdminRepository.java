package com.example.programmeringseksambackend.repository;


import com.example.programmeringseksambackend.model.Admin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("Admin")
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByAdminName(String adminName);
}
