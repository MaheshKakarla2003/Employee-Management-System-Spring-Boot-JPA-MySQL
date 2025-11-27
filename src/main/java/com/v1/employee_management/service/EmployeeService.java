package com.v1.employee_management.service;

import java.util.List;

import com.v1.employee_management.dto.EmployeeRequest;
import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.dto.EmployeeUpdateRequest;

import jakarta.validation.Valid;

public interface EmployeeService {

	EmployeeResponse addEmployee(@Valid EmployeeRequest req);

	EmployeeResponse getEmployee(long id);

	List<EmployeeResponse> getEmployees();

	String deleteEmployee(Long id);

	EmployeeResponse updateEmployee(long id, @Valid EmployeeUpdateRequest req);

	EmployeeResponse addProjectToEmployee(long id, String name);

	EmployeeResponse deleteProjectFromEmployee(Long id, String name);

}
