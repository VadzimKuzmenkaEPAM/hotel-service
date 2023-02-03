
package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface CustomerService {
    CustomerDto save (CustomerDto customerDto);
    public void register(Customer person);

}

