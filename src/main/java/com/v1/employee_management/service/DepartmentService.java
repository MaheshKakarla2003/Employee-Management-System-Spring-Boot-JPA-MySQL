package com.v1.employee_management.service;

import java.util.List;

import com.v1.employee_management.dto.DepartmentRequest;
import com.v1.employee_management.dto.DepartmentResponse;
import com.v1.employee_management.dto.EmployeeResponse;

import jakarta.validation.Valid;

public interface DepartmentService {

	 DepartmentResponse addDepartment(@Valid DepartmentRequest req);

	 DepartmentResponse getDepartment(long id);

	List<DepartmentResponse> getDepartments();

	List<EmployeeResponse> getEmployees(Long id);

	String deleteDepartment(Long id);

}
