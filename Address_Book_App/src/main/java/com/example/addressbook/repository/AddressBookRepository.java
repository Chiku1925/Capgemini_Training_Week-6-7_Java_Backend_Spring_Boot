package com.example.addressbook.repository;
import com.example.addressbook.model.AddressBookEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookEntry, Long> {
}