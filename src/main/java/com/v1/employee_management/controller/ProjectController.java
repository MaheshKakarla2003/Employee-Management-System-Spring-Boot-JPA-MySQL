package com.v1.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.dto.ProjectRequest;
import com.v1.employee_management.dto.ProjectResponse;
import com.v1.employee_management.entity.Employee;
import com.v1.employee_management.service.ProjectService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("pro")
public class ProjectController {

	
	@Autowired
	  private ProjectService prServ;
	
	@PostMapping()
	public ResponseEntity<ProjectResponse> addProject(@Valid @RequestBody ProjectRequest req)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(prServ.addProject(req));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProjectResponse> getProject(@PathVariable("id") long id) {
		return    ResponseEntity.ok(prServ.getProject(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<ProjectResponse>> getAll()
	{
		return ResponseEntity.ok(prServ.getAllProject());	
	}
	
	@GetMapping("emp/{id}")
	public List<EmployeeResponse> getEmployees(@PathVariable("id") long id) {
		return   prServ.getAllEmployees(id);
	}
	
	@DeleteMapping("{id}")
	public String  deleteProject(@PathVariable("id") long id)
	{
		return prServ.deleteProject(id);
	}
	
	
}
