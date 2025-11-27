package com.v1.employee_management.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeUpdateRequest {
	@NotBlank(message="please provide the name") @Size(min=2 ,max =25)
	private String name;
    @Email @NotBlank
    private String email;
    @NotBlank(message="please provide the job title name")
    private String  jobTitle;
    @Positive
    private Long departmentId;
}
