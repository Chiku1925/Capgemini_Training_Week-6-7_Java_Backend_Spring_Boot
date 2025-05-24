package com.example.addressbook.service.impl;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.exception.ResourceNotFoundException;
import com.example.addressbook.model.AddressBookEntry;
import com.example.addressbook.repository.AddressBookRepository;
import com.example.addressbook.service.AddressBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookRepository repository;

    public AddressBookEntry createEntry(AddressBookDTO dto) {
        AddressBookEntry entry = new AddressBookEntry();
        BeanUtils.copyProperties(dto, entry);
        return repository.save(entry);
    }

    public List<AddressBookEntry> getAllEntries() {
        return repository.findAll();
    }

    public AddressBookEntry getEntryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entry not found"));
    }

    public AddressBookEntry updateEntry(Long id, AddressBookDTO dto) {
        AddressBookEntry entry = getEntryById(id);
        BeanUtils.copyProperties(dto, entry);
        return repository.save(entry);
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}