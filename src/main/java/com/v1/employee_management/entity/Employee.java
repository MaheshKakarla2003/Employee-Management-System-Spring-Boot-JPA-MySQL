package com.v1.employee_management.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
    private String  name;
   @Column(unique =true)
    private String email;
    private String  jobTitle;
    
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;
    
    @OneToOne(mappedBy="employee", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private ParkingPass parkingPass;
    
    @Builder.Default
    @ManyToMany( mappedBy= "empList", fetch = FetchType.LAZY)
    private List<Project> projects = new ArrayList<>();  
    
    public void addProject(Project project)
    {
    	this.projects.add(project);          
        project.getEmpList().add(this); 
    }
    public void removeProject(Project project)
    {
    	this.projects.remove(project);          
        project.getEmpList().remove(this); 
    }
    
   
}
