package com.v1.employee_management.service;

import java.util.List;

import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.dto.ProjectRequest;
import com.v1.employee_management.dto.ProjectResponse;


import jakarta.validation.Valid;

public interface ProjectService {

	ProjectResponse addProject(@Valid ProjectRequest req);

	ProjectResponse getProject(long id);

	List<ProjectResponse> getAllProject();

	List<EmployeeResponse> getAllEmployees(long id);

	String deleteProject(long id);

}
