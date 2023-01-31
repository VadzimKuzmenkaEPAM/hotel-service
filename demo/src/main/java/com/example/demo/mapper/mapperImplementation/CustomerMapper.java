package com.example.demo.mapper.mapperImplementation;

import com.example.demo.dto.CustomerDto;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper implements Mapper<Customer, CustomerDto> {
    @Override
    public CustomerDto mapToDto(Customer entity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(entity.getCustomer_id());
        customerDto.setLogin(entity.getLogin());
        customerDto.setPassword(entity.getPassword());
        customerDto.setRole(entity.getRole());
        customerDto.setName(entity.getName());
        customerDto.setSurname(entity.getSurname());
        customerDto.setEmail(entity.getEmail());
        customerDto.setCardNumber(entity.getCardNumber());
        if (!(entity.getBookings() == null))
            customerDto.setBookings(entity.getBookings());
        return customerDto;
    }

    @Override
    public Customer mapToEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setCustomer_id(dto.getId());
        customer.setLogin(dto.getLogin());
        customer.setPassword(dto.getPassword());
        customer.setRole(dto.getRole());
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setEmail(dto.getEmail());
        customer.setCardNumber(dto.getCardNumber());
        if (!(dto.getBookings() == null))
            customer.setBookings(dto.getBookings());
        return customer;
    }
}


