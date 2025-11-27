package com.v1.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v1.employee_management.dto.ParkingPassRequest;
import com.v1.employee_management.dto.ParkingPassResponse;
import com.v1.employee_management.entity.Employee;
import com.v1.employee_management.entity.ParkingPass;
import com.v1.employee_management.exceptions.NotFoundException;
import com.v1.employee_management.mapper.DtoMapper;
import com.v1.employee_management.repository.EmployeeRepo;
import com.v1.employee_management.repository.ParkingPassRepo;

import jakarta.validation.Valid;

@Service
public class ParkingPassServiceImpl  implements ParkingPassService{
	
	@Autowired
	private ParkingPassRepo ppRepo;
	
	@Autowired
	  private EmployeeRepo empRepo;

	@Override
	public ParkingPassResponse addParkingPass(@Valid ParkingPassRequest req) {
	
		Employee emp=empRepo.findById(req.getEmployeeId()).orElseThrow(()->new NotFoundException("This employee id is not registered yet!"));
		
		
		return   DtoMapper.toParkingPassResponse  (ppRepo.save( DtoMapper.parkingPassToEntity(req, emp)));
	}

	@Override
	public ParkingPassResponse getParkingPass(@Valid String  name) {
	                return         DtoMapper.toParkingPassResponse(ppRepo.findBypassNumber(name).orElseThrow(()->
	                                                               new NotFoundException("This  " +name+"  Parking id is not registered yet")));
		
	}

	@Override
	public String deleteParkingPass(@Valid String  name) {
		
		
		ParkingPass pp= ppRepo.findBypassNumber(name).orElseThrow(()->
                                             new NotFoundException("This  " +name+"  Parking id is not registered yet"));
		ppRepo.delete(pp);
		return "This " + name +" Parking id is deleted successfully";
	}

	@Override
	public ParkingPassResponse updateParkingPass(long id ,@Valid ParkingPassRequest req) {
		
		ParkingPass pp= ppRepo.findById(id).orElseThrow(()->new NotFoundException("This Parking pass  id is not registered yet!"));
		
		Employee emp=empRepo.findById(req.getEmployeeId()).orElseThrow(()->new NotFoundException("This employee id is not registered yet!"));
		
		if(emp.getParkingPass()==null)
			 throw new NotFoundException("there is no Parking pass for the given Employee");
		
		pp.setPassNumber(req.getPassNumber());
		pp.setVehicleNumber(req.getVehicleNumber());
		pp.setEmployee(emp);
		pp.setValidTo(req.getValidTo());
		return  DtoMapper.toParkingPassResponse(ppRepo.save(pp));
	}

	@Override
	public List<ParkingPassResponse> getParkingPassList() {
		       return     ppRepo.findAll().stream().map(DtoMapper :: toParkingPassResponse).toList();
		
	}

}
