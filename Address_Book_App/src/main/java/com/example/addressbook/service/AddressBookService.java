package com.example.addressbook.service;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookEntry;
import java.util.List;

public interface AddressBookService {
    AddressBookEntry createEntry(AddressBookDTO dto);
    List<AddressBookEntry> getAllEntries();
    AddressBookEntry getEntryById(Long id);
    AddressBookEntry updateEntry(Long id, AddressBookDTO dto);
    void deleteEntry(Long id);
}