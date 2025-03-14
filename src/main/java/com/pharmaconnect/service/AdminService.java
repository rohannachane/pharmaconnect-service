package com.pharmaconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pharmaconnect.exception.ResourceNotFoundException;
import com.pharmaconnect.exception.ValidationException;
import com.pharmaconnect.model.Admin;
import com.pharmaconnect.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Create Admin
	public Admin createAdmin(Admin admin) {
		validateAdmin(admin);
		if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
			throw new ValidationException("Email already exists. Please use a different email.");
		}
		admin.setPassword(passwordEncoder.encode(admin.getPassword())); // Encode password before saving
		return adminRepository.save(admin);
	}

	// Get Admin by ID
	public Admin getAdminById(String id) {
		return adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found with ID: " + id));
	}

	// Update Admin
	public Admin updateAdmin(String id, Admin updatedAdmin) {
		Admin existingAdmin = getAdminById(id);
		validateAdmin(updatedAdmin);

		existingAdmin.setFullName(updatedAdmin.getFullName());
		existingAdmin.setEmail(updatedAdmin.getEmail());
		if (StringUtils.hasText(updatedAdmin.getPassword())) {
			existingAdmin.setPassword(passwordEncoder.encode(updatedAdmin.getPassword())); // Encode password during
																							// update
		}
		existingAdmin.setPhoneNumber(updatedAdmin.getPhoneNumber());
		existingAdmin.setManagedDoctorIds(updatedAdmin.getManagedDoctorIds());
		existingAdmin.setManagedPharmacyIds(updatedAdmin.getManagedPharmacyIds());

		return adminRepository.save(existingAdmin);
	}

	// Delete Admin
	public void deleteAdmin(String id) {
		Admin existingAdmin = getAdminById(id);
		adminRepository.delete(existingAdmin);
	}

	// Get All Admins
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	// Validate Admin Fields
	private void validateAdmin(Admin admin) {
		if (!StringUtils.hasText(admin.getEmail())) {
			throw new ValidationException("Email is required.");
		}
		if (!StringUtils.hasText(admin.getPassword())) {
			throw new ValidationException("Password is required.");
		}
		if (!StringUtils.hasText(admin.getFullName())) {
			throw new ValidationException("Full name is required.");
		}
		if (!StringUtils.hasText(admin.getPhoneNumber())) {
			throw new ValidationException("Phone number is required.");
		}
	}
}
