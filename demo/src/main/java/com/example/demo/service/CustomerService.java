
package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface CustomerService {
    CustomerDto save (CustomerDto customerDto);
    public void register(Customer person);

}

