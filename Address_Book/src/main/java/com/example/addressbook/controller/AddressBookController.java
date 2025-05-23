package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @PostMapping
    public ResponseEntity<AddressBookModel> add(@Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.createEntry(dto));
    }

    @GetMapping
    public ResponseEntity<List<AddressBookModel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> update(@PathVariable int id, @Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.updateEntry(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteEntry(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}