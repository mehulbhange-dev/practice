package com.example.practice.utility;

import com.example.practice.entity.Employee;
import com.example.practice.record.EmployeeRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeRecord toDTO(Employee employee);

    Employee toEntity(EmployeeRecord employeeRecord);
}
