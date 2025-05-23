package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.exception.EmployeeNotFoundException;
import com.example.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private int idCounter = 1;

    public Employee create(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setId(idCounter++);
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        employeeMap.put(emp.getId(), emp);
        return emp;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getById(int id) {
        Employee emp = employeeMap.get(id);
        if (emp == null) throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        return emp;
    }

    public Employee update(int id, EmployeeDTO dto) {
        Employee emp = getById(id);
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        return emp;
    }

    public void delete(int id) {
        if (employeeMap.remove(id) == null)
            throw new EmployeeNotFoundException("Cannot delete, no employee found with ID: " + id);
    }
}