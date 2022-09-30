package com.mertosi.customermanagement.common.mapper;

import com.mertosi.customermanagement.model.dto.request.customer.CustomerRequest;
import com.mertosi.customermanagement.model.entity.Customer;
import org.mapstruct.*;

@Mapper
public interface CustomerRequestMapper extends BaseMapper<CustomerRequest, Customer> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void requestToEntity(CustomerRequest source, @MappingTarget Customer target);
}
