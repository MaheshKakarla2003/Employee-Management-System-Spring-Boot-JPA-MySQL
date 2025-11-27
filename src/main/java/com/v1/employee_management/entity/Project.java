package com.v1.employee_management.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id ;
	  @Column(unique=true)
	  private String name;
	  
	  @Builder.Default
	  @ManyToMany( fetch = FetchType.LAZY)
	   @JoinTable(name="employee_projects" , joinColumns=@JoinColumn(name="project_id") ,
        inverseJoinColumns=@JoinColumn(name="employee_id") )
	  private List<Employee> empList = new ArrayList<>(); 
}
