package com.v1.employee_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v1.employee_management.entity.Employee;
import com.v1.employee_management.entity.ParkingPass;

import jakarta.validation.Valid;

public interface ParkingPassRepo extends JpaRepository<ParkingPass, Long> {

	Optional<ParkingPass> findBypassNumber(@Valid String name);

}
