package com.qnbeyond.customermanagement.common.mapper;

import com.qnbeyond.customermanagement.model.dto.response.customer.CustomerResponse;
import com.qnbeyond.customermanagement.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerResponseMapper extends BaseMapper<Customer, CustomerResponse> {
}
