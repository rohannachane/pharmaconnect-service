// Admin Controller
package com.pharmaconnect.controller;

import com.pharmaconnect.model.Admin;
import com.pharmaconnect.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	@GetMapping("/{id}")
	public Admin getAdminById(@PathVariable String id) {
		Admin admin = adminService.getAdminById(id);
		return admin;
	}

	@PostMapping
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable String id) {
		adminService.deleteAdmin(id);
		return ResponseEntity.ok().build();
	}
}
