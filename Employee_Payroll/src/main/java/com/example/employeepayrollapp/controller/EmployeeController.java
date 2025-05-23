package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}