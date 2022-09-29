package com.qnbeyond.customermanagement.repository;

import com.qnbeyond.customermanagement.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCommandRepository extends JpaRepository<Customer, Long> {
}
