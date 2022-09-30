package com.mertosi.customermanagement.model.entity;

import com.mertosi.customermanagement.model.TestDataBuilder;

public class CustomerBuilder extends TestDataBuilder<Customer> {

    public CustomerBuilder() {
        super(Customer.class);
    }

    public static Customer getValidCustomer() {
        return new CustomerBuilder().withId(1L).build();
    }

    public CustomerBuilder withId(Long id) {
        data.setId(id);
        return this;
    }
}
