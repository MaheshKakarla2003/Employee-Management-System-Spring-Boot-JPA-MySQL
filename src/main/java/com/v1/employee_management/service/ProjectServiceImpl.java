package com.v1.employee_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.dto.ProjectRequest;
import com.v1.employee_management.dto.ProjectResponse;
import com.v1.employee_management.entity.Employee;
import com.v1.employee_management.entity.Project;
import com.v1.employee_management.exceptions.NotFoundException;
import com.v1.employee_management.mapper.DtoMapper;
import com.v1.employee_management.repository.EmployeeRepo;
import com.v1.employee_management.repository.ProjectRepo;

import jakarta.validation.Valid;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo prRepo;
	
	@Autowired
	private EmployeeRepo  empRepo;
	
	@Override
	public ProjectResponse addProject(@Valid ProjectRequest req) {
		         
		List<Employee> empList= new ArrayList<>();
		    for(long id : req.getEmployeeId())
		    {
		    	empList.add(empRepo.findById(id).orElseThrow(()-> new NotFoundException("There is no Employee Found with this id  "+id)));
		    }
		  return    DtoMapper.toProjectResponse( prRepo.save(DtoMapper.toProjectEntity(req, empList)));
	
	}

	@Override
	public ProjectResponse getProject(long id) {
		            
		return DtoMapper.toProjectResponse(prRepo.findById(id).
				                   orElseThrow(()-> new NotFoundException("There is no such project found with this id  "+id)));
	}

	@Override
	public List<ProjectResponse> getAllProject() {
		
		return        prRepo.findAll().stream().map(DtoMapper::toProjectResponse).toList();
	}

	@Override
	public List<EmployeeResponse> getAllEmployees(long id) {
		          Project project=prRepo.findById(id). orElseThrow(()-> new NotFoundException("There is no such project found with this id  "+id));
		return project.getEmpList().stream().map(DtoMapper:: employeeToResponse).toList();
	}

	@Override
	public String deleteProject(long id) {
		
		Project project=prRepo.findById(id). orElseThrow(()-> new NotFoundException("There is no such project found with this id  "+id));
		 prRepo.delete(project);
		return "Project with the id  - " + id+" deleted  succesfully ! ("+ project.getName()+")" ;
	}

}
