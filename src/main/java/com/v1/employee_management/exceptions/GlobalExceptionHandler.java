package com.v1.employee_management.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class GlobalExceptionHandler {

	
	//Handeling cspecific exceptions
	
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public  ResponseEntity<ErrorMessage> handleValidation(MethodArgumentNotValidException ex , WebRequest req){
			
			ErrorMessage error = new ErrorMessage(LocalDateTime.now()
	                , "Invalid_request_body", 
	                ex.getMessage(), 
	                req.getDescription(false), 
	                HttpStatus.BAD_REQUEST);
			return new ResponseEntity<ErrorMessage>(error , HttpStatus.BAD_REQUEST);
			
		}
		@ExceptionHandler(NotFoundException.class)
		public  ResponseEntity<ErrorMessage> notFoundException(NotFoundException ex , WebRequest req){
			
			ErrorMessage error = new ErrorMessage(LocalDateTime.now()
	                , "not_found", 
	                ex.getMessage(), 
	                req.getDescription(false), 
	                HttpStatus.NOT_FOUND);
			return new ResponseEntity<ErrorMessage>(error , HttpStatus.NOT_FOUND);	
		}
		
		@ExceptionHandler(DataIntegrityViolationException.class)
		public  ResponseEntity<ErrorMessage> handleConflict(DataIntegrityViolationException ex , WebRequest req){
			
			ErrorMessage error = new ErrorMessage(LocalDateTime.now()
	                , "this profile is already exists in the database", 
	                 ex.getMessage(), 
	                req.getDescription(false), 
	                HttpStatus.CONFLICT);
			return new ResponseEntity<ErrorMessage>(error , HttpStatus.CONFLICT);	
		}
		
		
		
		@ExceptionHandler(MethodArgumentTypeMismatchException.class)
		public  ResponseEntity<ErrorMessage> typeMisMatch(MethodArgumentTypeMismatchException ex , WebRequest req){
			
			ErrorMessage error = new ErrorMessage(LocalDateTime.now()
	                , "type_mis_match", 
	                ex.getMessage(), 
	                req.getDescription(false), 
	                HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<ErrorMessage>(error , HttpStatus.NOT_ACCEPTABLE);	
		}
		
		@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
		public  ResponseEntity<ErrorMessage> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex , WebRequest req){
			
			ErrorMessage error = new ErrorMessage(LocalDateTime.now()
	                , "database constraint voilation", 
	                ex.getMessage(), 
	                req.getDescription(false), 
	                HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<ErrorMessage>(error , HttpStatus.NOT_ACCEPTABLE);	
		}
		
		
		//handeling generic exceptions
		
		@ExceptionHandler(Exception.class)
		public  ResponseEntity<ErrorMessage> handleAll(Exception ex , WebRequest req){
			
			ErrorMessage error = new ErrorMessage(LocalDateTime.now()
	                , "Internal_server_error", 
	                ex.getMessage(), 
	                req.getDescription(false), 
	                HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<ErrorMessage>(error , HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		
		
}
