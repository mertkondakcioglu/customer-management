package com.mertosi.customermanagement.service.customer;

import com.mertosi.customermanagement.model.dto.request.customer.CustomerRequest;
import com.mertosi.customermanagement.model.entity.Customer;

public interface CustomerCommandService {
    Customer create(CustomerRequest request);

    Customer update(Long id, CustomerRequest request);

    Customer delete(Long id);
}
