
package com.example.demo.service.implementation;

import com.example.demo.dto.CustomerDto;
import com.example.demo.exceptions.AppException;
import com.example.demo.exceptions.ErrorCode;
import com.example.demo.mapper.mapperImplementation.CustomerMapper;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.security.userDetails.UsersDetails;
import com.example.demo.service.CustomerService;
import com.example.demo.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("customerServiceImplementation")
public class CustomerServiceImplementation implements CustomerService {

    private static final String ROLE_USER = "ROLE_USER";

    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository, CustomerValidator customerValidator, CustomerMapper mapper) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public CustomerDto save(CustomerDto customerDto) {
        customerValidator.validate(customerDto);
        Customer customer = mapper.mapToEntity(customerDto);
        Customer customerInDb = customerRepository.save(customer);
        return mapper.mapToDto(customerInDb);
    }

    @Transactional
    @Override
    public void register(Customer person) {
        person.setRole(ROLE_USER);
        customerRepository.save(person);
    }


}