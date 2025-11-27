package com.v1.employee_management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v1.employee_management.dto.DepartmentRequest;
import com.v1.employee_management.dto.DepartmentResponse;
import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentService deptServ;
	
	@PostMapping()
	public ResponseEntity<DepartmentResponse> addDepartment(@Valid @RequestBody DepartmentRequest req)
	{
		               return ResponseEntity.status(HttpStatus.CREATED).body(deptServ.addDepartment(req)) ;
	}
	

	@GetMapping("{id}")
	public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable("id") long id)
	{
		return    ResponseEntity.ok( deptServ.getDepartment(id))  ;
	}
	
	
	@GetMapping("departments")
	public ResponseEntity<List<DepartmentResponse>> getDepartments()
	{
		return    ResponseEntity.ok( deptServ.getDepartments())  ;
	}
	
	@GetMapping("dept-employees/{id}")
	public ResponseEntity<List<EmployeeResponse>> getEmployees(@PathVariable("id") long id)
	{
		return    ResponseEntity.ok( deptServ.getEmployees(id))  ;
	}
	
	
	@DeleteMapping("delete/{id}")
	public String deleteDepartment(@PathVariable("id") Long id)
	{
		return deptServ.deleteDepartment(id);
	}
}
