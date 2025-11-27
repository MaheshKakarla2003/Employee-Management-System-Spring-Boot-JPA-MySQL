package com.v1.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v1.employee_management.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {

	Project findByName(String name);

}
