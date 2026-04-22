package com.example.practice.service.impl;

import com.example.practice.entity.Employee;
import com.example.practice.record.EmployeeRecord;
import com.example.practice.repository.EmployeeRepository;
import com.example.practice.service.EmployeeService;
import com.example.practice.utility.EmployeeMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeRecord createEmployee(EmployeeRecord employeeRecord) {
        Employee employee = this.employeeMapper.toEntity(employeeRecord);
        log.info("[createEmployee] Employee Entity : {}", employee);
        Employee createdEmployee = this.employeeRepository.save(employee);
        log.info("[createEmployee] Created Employee Entity : {}", createdEmployee);
        return this.employeeMapper.toDTO(createdEmployee);
    }

    @Override
    public EmployeeRecord getEmployeeById(String id) {
        Employee employee = this.employeeRepositor.findById(id).orElse(null);
        log.info("[getEmployeeById] employee {} ", employee);
        if (employee != null)
            return this.employeeMapper.toDTO(employee);
        return null;
    }

    @Override
    public List<EmployeeRecord> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees.stream().map(this.employeeMapper::toDTO).toList();
    }

    @Override
    public EmployeeRecord deleteEmployee(String employeeId) {
        return null;
    }
}
