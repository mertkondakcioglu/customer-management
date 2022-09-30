package com.mertosi.customermanagement.repository.customer;

import com.mertosi.customermanagement.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerQueryRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
