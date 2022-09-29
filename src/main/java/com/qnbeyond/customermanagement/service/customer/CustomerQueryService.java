package com.qnbeyond.customermanagement.service.customer;

import com.qnbeyond.customermanagement.model.entity.Customer;

import java.util.List;

public interface CustomerQueryService {
    List<Customer> getAll();

    Customer getById(Long id);

    Customer getByEmail(String email);
}
