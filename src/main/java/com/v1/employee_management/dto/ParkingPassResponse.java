package com.v1.employee_management.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingPassResponse {

	 private Long id;
	  private String passNumber;
	  private String vehicleNumber;
	  private LocalDate validTo;
	  private String  employeeName;
}
