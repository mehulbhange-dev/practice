package com.example.practice.record;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EmployeeRecord(
        @NotNull long employeeId,
        @NotBlank @Size(min = 3, message = "Name must be at least 3 character long") String name,
        @NotBlank @NotNull String department,
        @Min(value = 0, message = "Salary should not be negative") Double salary,
        @Size(min = 3) String city,
        LocalDate joiningDate) {
}
