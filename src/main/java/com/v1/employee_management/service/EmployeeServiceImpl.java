package com.v1.employee_management.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.v1.employee_management.dto.EmployeeRequest;
import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.dto.EmployeeUpdateRequest;
import com.v1.employee_management.entity.Department;
import com.v1.employee_management.entity.Employee;
import com.v1.employee_management.entity.Project;
import com.v1.employee_management.exceptions.NotFoundException;
import com.v1.employee_management.mapper.DtoMapper;
import com.v1.employee_management.repository.DepartmentRepo;
import com.v1.employee_management.repository.EmployeeRepo;
import com.v1.employee_management.repository.ProjectRepo;

import jakarta.validation.Valid;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	  private EmployeeRepo empRepo;
	
	@Autowired
	  private DepartmentRepo  deptRepo;
	
	@Autowired
	  private  ProjectRepo  projectRepo;
	
	
	@Override
	public EmployeeResponse addEmployee(@Valid EmployeeRequest req) {
	          
		 long  deptId = req.getDepartmentId();
		Department dept =  deptRepo.findById(deptId).orElseThrow(()-> new NotFoundException(" This Department id is not registered !"));
		 
		 List<Project> projects= new ArrayList<>();
		for(String name : req.getProjectList())
		{
			   Project project = projectRepo.findByName(name);
			    if (project == null) {
			         continue;
			    }
			    projects.add(project);
		}		
		
		Employee emp= DtoMapper.employeeToEntity(req, dept);
		
                  for (Project p : projects) {
                          emp.addProject(p);    
                             }
		 
	     return     DtoMapper.employeeToResponse(empRepo.save(emp) );     
		
	}


	@Override
	public EmployeeResponse getEmployee(long id) {
	    
		return    DtoMapper.employeeToResponse(empRepo.findById(id).
				                               orElseThrow(()-> new NotFoundException("This employee id is not registered yet!")));
	}


	@Override
	public List<EmployeeResponse> getEmployees() {
		
		return empRepo.findAll().stream().map(DtoMapper :: employeeToResponse ).toList();
	}


	@Override
	public String deleteEmployee(Long id) {
		         Employee emp=empRepo.findById(id).orElseThrow(()-> new NotFoundException("This employee id is not registered yet!"));
		         empRepo.delete(emp);
		return "Employee  "+emp.getId()+"  ->  "+emp.getName() +"  is deleted succesfully ";
	}


	@Override
	public EmployeeResponse updateEmployee(long id, @Valid EmployeeUpdateRequest req) {
		
		   Employee emp=empRepo.findById(id).orElseThrow(()-> new NotFoundException("This employee id is not registered yet!"));
		          emp.setName(req.getName());
		          emp.setEmail(req.getEmail());
		          emp.setJobTitle(req.getJobTitle());
		          long  deptId = req.getDepartmentId();
		  		Department dept =  deptRepo.findById(deptId).orElseThrow(()-> new NotFoundException(" This Department id is not registered !"));
		  		emp.setDepartment(dept);
		
		  		 return      DtoMapper.employeeToResponse(empRepo.save(emp));
		
	}


	@Override
	public EmployeeResponse addProjectToEmployee(long id, String name) {
		  
		 Employee emp=empRepo.findById(id).orElseThrow(()-> new NotFoundException("This employee id is not registered yet!"));
		 Project project=projectRepo.findByName(name);
	                    if(	project==null)
	                    	{
	                    	   throw new NotFoundException("No project found with this name "+name);
	                    	}
	                    if(emp.getProjects().contains(project))
	                    	throw  new DataIntegrityViolationException("This "+name+" Project is already assigned to the employee !!");
	                                        
	                    emp.addProject(project);
	                    	
		return  DtoMapper.employeeToResponse(empRepo.save(emp));
	}


	@Override
	public EmployeeResponse deleteProjectFromEmployee(Long id, String name) {
		
		 Employee emp=empRepo.findById(id).orElseThrow(()-> new NotFoundException("This employee id is not registered yet!"));
		 Project project=projectRepo.findByName(name);
	                    if(	project==null)
	                    	{
	                    	   throw new NotFoundException("No project found with this name "+name);
	                    	}
	                    
	                    if(!emp.getProjects().contains(project))
	                    	throw  new NotFoundException("This "+name+" Project is not  assigned to the employee yet  !!");
	                    
	                    emp.removeProject(project);
	                    	
		return  DtoMapper.employeeToResponse(empRepo.save(emp));
	}
	

	
	
	
	
	
	
	
	
	
}
