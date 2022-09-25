package com.qnbeyond.customermanagement.service.customer;

import com.qnbeyond.customermanagement.model.entity.CustomerEntity;

import java.util.List;

public interface CustomerQueryService {
    List<CustomerEntity> getAll();

    CustomerEntity getById(Long id);

    CustomerEntity getByEmail(String email);
}
