package com.qnbeyond.customermanagement.service.customer;

import com.qnbeyond.customermanagement.model.dto.request.customer.CustomerRequest;
import com.qnbeyond.customermanagement.model.entity.Customer;

public interface CustomerCommandService {
    Customer create(CustomerRequest request);

    Customer update(Long id, CustomerRequest request);

    Customer delete(Long id);
}
