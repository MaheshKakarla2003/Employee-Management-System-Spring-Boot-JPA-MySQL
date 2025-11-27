package com.v1.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v1.employee_management.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
