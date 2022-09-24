package com.qnbeyond.customermanagement.service;

import com.qnbeyond.customermanagement.model.entity.CustomerEntity;

import java.util.List;

public interface CustomerQueryService {
    List<CustomerEntity> getAll();

    CustomerEntity getById(Long id);
}
