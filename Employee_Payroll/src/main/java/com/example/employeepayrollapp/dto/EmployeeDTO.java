package com.example.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\s]{2,}$", message = "Name is invalid")
    private String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private long salary;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getSalary() { return salary; }
    public void setSalary(long salary) { this.salary = salary; }
}