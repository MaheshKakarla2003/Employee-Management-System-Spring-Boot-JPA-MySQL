package com.v1.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v1.employee_management.dto.ParkingPassRequest;
import com.v1.employee_management.dto.ParkingPassResponse;
import com.v1.employee_management.service.ParkingPassService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pp")
public class ParkingPassController {

	@Autowired
	private ParkingPassService ppServ;
	
	@PostMapping()
	public ResponseEntity<ParkingPassResponse> addParkingPass(@Valid @RequestBody ParkingPassRequest req)
	{
		            return ResponseEntity.status(HttpStatus.CREATED).body(ppServ.addParkingPass(req));
	}

	@GetMapping()
	public ResponseEntity<ParkingPassResponse> getParkingPass(@RequestParam("ParkingPass-Number") @Valid String  name)
	{
		            return ResponseEntity.ok(ppServ.getParkingPass(name));
	}
	
	@GetMapping("list")
	public ResponseEntity<List<ParkingPassResponse>> getParkingPassList()
	{
		            return ResponseEntity.ok(ppServ.getParkingPassList());
	}
	
	

	@PutMapping("{id}")
	public ResponseEntity<ParkingPassResponse>  updateParkingPass(@PathVariable("id") long id,@Valid @RequestBody ParkingPassRequest req)
	{
		
		            return ResponseEntity.ok(ppServ.updateParkingPass(id,req));
		            
	}
	
	@DeleteMapping()
	public String deleteParkingPass(@RequestParam("ParkingPass-Number") @Valid String  name)
	{
		return ppServ.deleteParkingPass(name);
	}
	
		
	
}
