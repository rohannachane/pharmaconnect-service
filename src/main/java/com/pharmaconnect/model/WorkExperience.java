package com.pharmaconnect.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkExperience {
	private String organisationName;
	private String hospitalName;
	private String position;
	private List<String> responsibilities;
	private double yearOfExperience;

}