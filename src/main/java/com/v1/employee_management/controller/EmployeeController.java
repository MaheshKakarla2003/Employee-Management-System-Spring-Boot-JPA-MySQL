package com.v1.employee_management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.v1.employee_management.dto.DepartmentResponse;
import com.v1.employee_management.dto.EmployeeRequest;
import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.dto.EmployeeUpdateRequest;
import com.v1.employee_management.service.EmployeeService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/emp")
public class EmployeeController {

	
	      @Autowired
	      private EmployeeService empServ;
	      
	      @PostMapping()
	      public ResponseEntity<EmployeeResponse>    addEmployee(@Valid @RequestBody EmployeeRequest req)
	      {
	    	  
	    	  return ResponseEntity.status(HttpStatus.CREATED).body(empServ.addEmployee(req)) ;
	      }
	      
	      @GetMapping("{id}")
	      public ResponseEntity<EmployeeResponse>    getEmployee(@PathVariable("id") long id)
	      {
	    	  return ResponseEntity.ok(empServ.getEmployee(id));
	      }
	       
	      @GetMapping("employees")
	  	public ResponseEntity<List<EmployeeResponse>> getEmployees()
	  	{
	  		return    ResponseEntity.ok( empServ.getEmployees())  ;
	  	}
	      
	      @PutMapping("update/{id}")
	      public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") long id , @Valid @RequestBody EmployeeUpdateRequest req )
	      {
	    	  return ResponseEntity.ok(empServ.updateEmployee(id, req) );
	      }
	      
	      
	     @DeleteMapping("delete/{id}")
	  	public String deleteEmployee(@PathVariable("id") Long id)
	  	{
	  		return empServ.deleteEmployee(id);
	  	}
	      
	     @PutMapping("emp-project-add/{id}")
	     public ResponseEntity<EmployeeResponse> addProjectToEmployee(@PathVariable("id") long id , @RequestParam("name") String name)
	     {
	    	             return ResponseEntity.ok(empServ.addProjectToEmployee(id , name));
	     }
	      
	     @DeleteMapping("emp-project-delete/{id}")
		  	public ResponseEntity<EmployeeResponse>  deleteProjectFromEmployee(@PathVariable("id") Long id,@RequestParam("name") String name)
		  	{
		  		return    ResponseEntity.ok(empServ.deleteProjectFromEmployee(id , name));
		  	}
	      
}
