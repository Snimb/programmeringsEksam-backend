package com.example.programmeringseksambackend.service;

import com.example.programmeringseksambackend.model.Admin;
import com.example.programmeringseksambackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Admin findById(Integer id) {
        return adminRepository.findById(id).orElseThrow(() -> new NoResultException("Admin with id: " + id + " was not found"));
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin, Integer id) {
        Admin adminData = adminRepository.findById(id).orElseThrow(() -> new NoResultException("Admin with id: " + id + " was not found"));
        adminData.setAdminName(admin.getAdminName());
        adminData.setAdminPassword(admin.getAdminPassword());
        return adminRepository.save(adminData);
    }


    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }


    public Admin findByAdminName(String adminName) {
        return adminRepository.findByAdminName(adminName);
    }


    public Integer login(String adminName, String adminPassword) {
        Admin admin = adminRepository.findByAdminName(adminName);
        Integer adminID = admin.getAdminID();

        if(admin.getAdminName().equals(adminName) && admin.getAdminPassword().equals(adminPassword)) {
            System.out.println("Login Succeed");
            return adminID;
        }
        else {
            System.out.println("Failed to login");
            return null;
        }

    }

}
