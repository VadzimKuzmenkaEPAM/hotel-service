package com.example.demo.security.implementation;

import com.example.demo.exceptions.AppException;
import com.example.demo.exceptions.ErrorCode;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.security.SecurityService;
import com.example.demo.security.userDetails.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SecurityServiceImplementation implements SecurityService {
    private final CustomerRepository customerRepository;

    @Autowired
    public SecurityServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Customer> user = Optional.ofNullable(customerRepository.readByName(login)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
        return new CustomerDetails(user.get());
    }
}