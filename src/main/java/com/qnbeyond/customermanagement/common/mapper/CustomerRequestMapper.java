package com.qnbeyond.customermanagement.common.mapper;

import com.qnbeyond.customermanagement.model.dto.request.CustomerRequest;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import org.mapstruct.*;

@Mapper
public interface CustomerRequestMapper extends BaseMapper<CustomerRequest, CustomerEntity> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void requestToEntity(CustomerRequest source, @MappingTarget CustomerEntity target);
}
