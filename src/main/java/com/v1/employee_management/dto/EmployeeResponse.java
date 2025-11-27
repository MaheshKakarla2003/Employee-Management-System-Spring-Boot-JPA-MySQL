package com.v1.employee_management.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

	private long id;
	private String name;
	private String email;
	private String jobTitle;
	private String departmentName;
	private String parkingPassNumber;      
	  private List<String> projectNames; 
}
