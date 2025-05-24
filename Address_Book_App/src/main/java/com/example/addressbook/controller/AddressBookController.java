package com.example.addressbook.controller;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookEntry;
import com.example.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {
    @Autowired
    private AddressBookService service;

    @PostMapping
    public ResponseEntity<AddressBookEntry> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.createEntry(dto));
    }

    @GetMapping
    public ResponseEntity<List<AddressBookEntry>> getAll() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookEntry> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEntryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookEntry> update(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.updateEntry(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}