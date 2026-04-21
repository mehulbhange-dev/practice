package com.example.practice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "employees")
@Data
public class Employee {

    @Id
    private String id;
    @Indexed(unique = true)
    private long employeeId;
    private String name;
    private String department;
    private Double salary;
    private String city;
    private LocalDate joiningDate;

}
