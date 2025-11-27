package com.v1.employee_management.dto;


import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequest {

	@NotBlank(message="please provide the project name")
	private String  name;
	
	@NotEmpty
	private List< Long> employeeId;
	
}
