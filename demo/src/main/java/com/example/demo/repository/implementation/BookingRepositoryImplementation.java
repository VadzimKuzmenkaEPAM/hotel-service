package com.example.demo.repository.implementation;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
@EnableTransactionManagement
@Repository
public class BookingRepositoryImplementation implements BookingRepository {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEm(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Booking create(Booking booking) {
        return entityManager.merge(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Booking readById(Long id) {
        return null;
    }
}