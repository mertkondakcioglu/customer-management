package com.mertosi.customermanagement.service.customer;

import com.mertosi.customermanagement.model.entity.Customer;

import java.util.List;

public interface CustomerQueryService {
    List<Customer> getAll();

    Customer getById(Long id);

    Customer getByEmail(String email);
}
