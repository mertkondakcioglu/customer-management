package com.qnbeyond.customermanagement.model.entity;

import com.qnbeyond.customermanagement.model.TestDataBuilder;

public class CustomerEntityBuilder extends TestDataBuilder<CustomerEntity> {

    public CustomerEntityBuilder() {
        super(CustomerEntity.class);
    }

    public static CustomerEntity getValidCustomerEntity() {
        return new CustomerEntityBuilder().withId(1L).build();
    }

    public CustomerEntityBuilder withId(Long id) {
        data.setId(id);
        return this;
    }
}
