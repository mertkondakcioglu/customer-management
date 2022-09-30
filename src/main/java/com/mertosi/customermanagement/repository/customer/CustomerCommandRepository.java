package com.mertosi.customermanagement.repository.customer;

import com.mertosi.customermanagement.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCommandRepository extends JpaRepository<Customer, Long> {
}
