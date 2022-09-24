package com.qnbeyond.customermanagement.model.dto.request;

import com.qnbeyond.customermanagement.model.TestDataBuilder;

public class CustomerRequestBuilder extends TestDataBuilder<CustomerRequest> {

    public CustomerRequestBuilder() {
        super(CustomerRequest.class);
    }

    public static CustomerRequest getValidCustomerRequest() {
        return new CustomerRequestBuilder()
                .withEmail("abc@abc.com")
                .build();
    }

    public CustomerRequestBuilder withEmail(String email) {
        data.setEmail(email);
        return this;
    }
}
