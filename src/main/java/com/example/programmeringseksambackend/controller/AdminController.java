package com.example.programmeringseksambackend.controller;

import com.example.programmeringseksambackend.model.Admin;
import com.example.programmeringseksambackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"})
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Integer id) {
        Admin admin = adminService.findById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) throws URISyntaxException {
        Admin result = null;
        if (adminService.findByAdminName(admin.getAdminName()) != null) {
            return (ResponseEntity<Admin>) ResponseEntity.ok();
        } else
            result = adminService.saveAdmin(admin);
        return ResponseEntity.created(new URI("/admin/" + result.getAdminID())).body((result));
    }

    @PutMapping("admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
        Admin tmpAdmin = adminService.updateAdmin(admin, id);
        return ResponseEntity.ok().body(tmpAdmin);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public Integer adminLogin(@RequestBody Map<String, Object> admin) {
        String adminName = admin.get("adminName").toString();
        String adminPassword = admin.get("adminPassword").toString();
        return adminService.login(adminName, adminPassword);

    }
}
