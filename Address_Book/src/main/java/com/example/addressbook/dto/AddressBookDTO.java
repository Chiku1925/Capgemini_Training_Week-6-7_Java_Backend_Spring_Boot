package com.example.addressbook.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name is invalid")
    private String name;

    @NotEmpty(message = "Address cannot be empty")
    private String address;
}