package com.pharmaconnect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Qualification {
	private String schoolName;
	private String degree;
	private Integer passingYear;
	private String location;
}