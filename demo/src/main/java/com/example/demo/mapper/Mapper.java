package com.example.demo.mapper;

import org.springframework.stereotype.Service;

@Service
public interface Mapper<T, E> {

    E mapToDto(T entity);

    T mapToEntity(E dto);
}
