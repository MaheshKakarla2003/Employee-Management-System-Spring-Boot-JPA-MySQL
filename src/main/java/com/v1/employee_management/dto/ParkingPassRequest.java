package com.v1.employee_management.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingPassRequest {

	@NotBlank(message="please provide the pass number")
      private String passNumber;
	@NotBlank(message="please provide the vehicle number")
	  private String vehicleNumber;
	@Future
	  private LocalDate validTo;
	@Positive
	private Long employeeId;
}
