package com.v1.employee_management.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {

	private LocalDateTime timestamp;
	private String error;
	private  String message;
	private String path;
	private HttpStatus status;
}
