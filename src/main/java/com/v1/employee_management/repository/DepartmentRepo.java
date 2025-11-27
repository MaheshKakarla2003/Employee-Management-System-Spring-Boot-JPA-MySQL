package com.v1.employee_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v1.employee_management.entity.Department;

public interface DepartmentRepo  extends JpaRepository<Department, Long>{

	Department save(Department dept);

                
}
