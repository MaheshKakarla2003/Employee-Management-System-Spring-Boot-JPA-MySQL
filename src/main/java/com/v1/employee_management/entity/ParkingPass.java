package com.v1.employee_management.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class ParkingPass {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
    @Column(unique =true)
    private String passNumber;
    @Column(unique =true)
    private String vehicleNumber;
    private LocalDate validTo;
    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="employee_id")
    private Employee employee;
    
}
