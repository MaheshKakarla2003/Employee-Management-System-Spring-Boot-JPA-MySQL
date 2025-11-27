package com.v1.employee_management.service;

import java.util.List;

import com.v1.employee_management.dto.ParkingPassRequest;
import com.v1.employee_management.dto.ParkingPassResponse;

import jakarta.validation.Valid;

public interface ParkingPassService {

	ParkingPassResponse addParkingPass(@Valid ParkingPassRequest req);

	ParkingPassResponse getParkingPass(@Valid String  name);

	String deleteParkingPass(@Valid String  name);

	ParkingPassResponse updateParkingPass(long id, @Valid ParkingPassRequest req);

	List<ParkingPassResponse> getParkingPassList();

}
