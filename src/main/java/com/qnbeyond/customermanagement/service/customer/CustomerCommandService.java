package com.qnbeyond.customermanagement.service.customer;

import com.qnbeyond.customermanagement.model.dto.request.customer.CustomerRequest;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;

public interface CustomerCommandService {
    CustomerEntity create(CustomerRequest request);

    CustomerEntity update(Long id, CustomerRequest request);

    CustomerEntity delete(Long id);
}
