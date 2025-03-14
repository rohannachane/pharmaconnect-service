package com.pharmaconnect.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "appointments")
public class Appointment {
	@Id
	private String id;

	private String doctorId;
	private String patientId;

	private String appointmentDate;
	private String appointmentTime;
	private String status;

	private String adminId;
	private String prescriptionId;
}