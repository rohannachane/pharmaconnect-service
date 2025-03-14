package com.pharmaconnect.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "admins")
public class Admin {
	@Id
	private String id;

	private String email;
	private String password;
	private String fullName;
	private String phoneNumber;

	// Admin Privileges
	private List<String> managedDoctorIds;
	private List<String> managedPharmacyIds;
}