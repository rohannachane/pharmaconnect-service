package com.pharmaconnect.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fileResources")
public class FileResource {
	@Id
	private String id;

	private String fileName;
	private String fileType; // IMAGE, PDF
	private byte[] data; // Binary data for MongoDB GridFS

	private String uploadedBy; // "DOCTOR", "PATIENT", "ADMIN"
	private String referenceId; // Doctor ID, Patient ID, or Admin ID
}