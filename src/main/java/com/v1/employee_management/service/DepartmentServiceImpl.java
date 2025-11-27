package com.v1.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v1.employee_management.dto.DepartmentRequest;
import com.v1.employee_management.dto.DepartmentResponse;
import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.entity.Department;
import com.v1.employee_management.exceptions.NotFoundException;
import com.v1.employee_management.mapper.DtoMapper;
import com.v1.employee_management.repository.DepartmentRepo;

import jakarta.validation.Valid;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo deptRepo;
	@Override
	public DepartmentResponse addDepartment(@Valid DepartmentRequest req) {
		
		return      DtoMapper.departmentToResponse(deptRepo.save(DtoMapper.departmentToEntity(req)));

	}
	@Override
	public DepartmentResponse getDepartment(long id) {
		
		return     DtoMapper.departmentToResponse(deptRepo.findById(id).orElseThrow(()-> new NotFoundException("This Department id is not registered !")))    ;
	}
	@Override
	public List<DepartmentResponse> getDepartments() {

		return    deptRepo.findAll().stream().map(DtoMapper :: departmentToResponse ).toList();
	}
	@Override
	public List<EmployeeResponse> getEmployees(Long id) {
		         
		Department dept = deptRepo.findById(id).orElseThrow(()-> new NotFoundException("This Department id is not registered !"));
		      
		List<EmployeeResponse> list= dept.getEmployees() .stream().map(DtoMapper :: employeeToResponse ).toList() ;      
		return list;
	}
	@Override
	public String deleteDepartment(Long id) {
		Department dept = deptRepo.findById(id).orElseThrow(()-> new NotFoundException("This Department id is not registered !"));
		            deptRepo.deleteById(id);
		            String  name=dept.getName();
		return  name+"  department is deleted successfully";
	}

}
