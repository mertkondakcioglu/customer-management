package com.mertosi.customermanagement.common.mapper.customer;

import com.mertosi.customermanagement.common.mapper.BaseMapper;
import com.mertosi.customermanagement.model.dto.response.customer.CustomerResponse;
import com.mertosi.customermanagement.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerResponseMapper extends BaseMapper<Customer, CustomerResponse> {
}
