package com.pharmaconnect.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "doctors")
public class Doctor {
	@Id
	private String doctorId;

	private String fullName;
	private String email;
	private String password;
	private String gender;
	private LocalDate dob;
	private String address;
	private String street;
	private String city;
	private String state;
	private int postalCode;
	private String phoneNumber;
	private String specialization;

	private String profilePictureId;
	private List<String> fileResourceIds;

	private String consultationFee;
	private List<String> availableDays;
	private String availableHours;

	private List<Qualification> qualifications;
	private List<WorkExperience> workExperience;

	private boolean isApproved;
	private String adminId;
}