package com.v1.employee_management.mapper;

import java.util.List;
import java.util.Set;

import com.v1.employee_management.dto.DepartmentRequest;
import com.v1.employee_management.dto.DepartmentResponse;
import com.v1.employee_management.dto.EmployeeRequest;
import com.v1.employee_management.dto.EmployeeResponse;
import com.v1.employee_management.dto.ParkingPassRequest;
import com.v1.employee_management.dto.ParkingPassResponse;
import com.v1.employee_management.dto.ProjectRequest;
import com.v1.employee_management.dto.ProjectResponse;
import com.v1.employee_management.entity.Department;
import com.v1.employee_management.entity.Employee;
import com.v1.employee_management.entity.ParkingPass;
import com.v1.employee_management.entity.Project;

import jakarta.validation.Valid;

public class DtoMapper {

	
	public static  Department departmentToEntity(DepartmentRequest req)
	{
	 return  Department.builder(). name(req.getName()).
				                                    build();
		
	}
	
	public static DepartmentResponse departmentToResponse(Department dept)
	{
		return  DepartmentResponse.builder().  id(dept.getId()).
				                                                         name(dept.getName()).
				                                                         employeeCount(dept.getEmployees() == null ? 0 : dept.getEmployees().size() ).
				                                                        build();
		
	}
	
	
	
	public static Employee  employeeToEntity(EmployeeRequest req , Department dept )
	{
		return  Employee.builder(). name(req.getName())
				                                    .email(req.getEmail())
				                                    .jobTitle(req.getJobTitle())
				                                    .department(dept).			                                   
				                                 build();
		
	}
	
	
	
	public static EmployeeResponse employeeToResponse(Employee emp)
	{
	     return EmployeeResponse.builder(). id(emp.getId())
				                                      .name(emp.getName())
				                                      .email(emp.getEmail())
				                                      .jobTitle(emp.getJobTitle())
				                                      .departmentName(emp.getDepartment()==null? "no department is registered" : emp.getDepartment().getName())
				                                      .parkingPassNumber(emp.getParkingPass()==null? "no parking pass available" : emp.getParkingPass().getPassNumber())
				                                      .projectNames(emp.getProjects()==null? null : emp.getProjects().stream().map( Project :: getName).toList()).
				                                      
				                          build();
	}
	
	
	
	
	public static ParkingPass parkingPassToEntity(ParkingPassRequest req , Employee emp)
	{
		return ParkingPass.builder(). passNumber(req.getPassNumber())
				                            .vehicleNumber(req.getVehicleNumber())
				                            .validTo(req.getValidTo())
				                            .employee(emp)
			                            .build();			                           
	}
	
	public static ParkingPassResponse toParkingPassResponse(ParkingPass pp)
	{
		return ParkingPassResponse.builder()
				                              .id(pp.getId())
				                              .passNumber(pp.getPassNumber())
				                              .vehicleNumber(pp.getVehicleNumber())
				                              .validTo(pp.getValidTo())
				                              .employeeName(pp.getEmployee()==null ? "no employee id registred":  pp.getEmployee().getName())
				                              .build();
	}
	
	
	public static Project toProjectEntity(ProjectRequest req , List<Employee> employeeList)
	{
		return Project.builder().
				                      name(req.getName()).
				                      empList(employeeList).
				                    build();
	}
	
	public static ProjectResponse toProjectResponse(Project  p)
	{
		return ProjectResponse.builder()
				                              .id(p.getId())
				                              .name(p.getName())
				                              .employeeCount(p.getEmpList()==null? 0 : p.getEmpList().size())
				                              .build();
	}
}
