package com.v1.employee_management.dto;

import java.util.List;
import com.v1.employee_management.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {

	private long id;
	private String name;
	private long employeeCount;
}
