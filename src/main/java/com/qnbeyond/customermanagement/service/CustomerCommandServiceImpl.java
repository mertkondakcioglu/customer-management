package com.qnbeyond.customermanagement.service;

import com.qnbeyond.customermanagement.common.mapper.CustomerRequestMapper;
import com.qnbeyond.customermanagement.model.dto.request.CustomerRequest;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import com.qnbeyond.customermanagement.repository.CustomerCommandRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCommandServiceImpl implements CustomerCommandService {

    private final CustomerCommandRepository customerCommandRepository;
    private final CustomerQueryService customerQueryService;

    private final CustomerRequestMapper mapper = Mappers.getMapper(CustomerRequestMapper.class);

    @Override
    public CustomerEntity create(CustomerRequest request) {
        CustomerEntity customerEntity = mapper.map(request);
        return customerCommandRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity update(Long id, CustomerRequest request) {
        CustomerEntity customerEntityToUpdated = customerQueryService.getById(id);
        mapper.requestToEntity(request, customerEntityToUpdated);

        return customerCommandRepository.save(customerEntityToUpdated);
    }

    @Override
    public CustomerEntity delete(Long id) {
        CustomerEntity customerEntityToDeleted = customerQueryService.getById(id);
        customerCommandRepository.delete(customerEntityToDeleted);

        return customerEntityToDeleted;
    }
}
