package com.qnbeyond.customermanagement.repository;

import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerQueryRepository extends JpaRepository<CustomerEntity, Long> {
}
