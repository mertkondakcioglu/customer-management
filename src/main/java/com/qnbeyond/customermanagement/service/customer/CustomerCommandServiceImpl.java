package com.qnbeyond.customermanagement.service.customer;

import com.qnbeyond.customermanagement.common.mapper.CustomerRequestMapper;
import com.qnbeyond.customermanagement.model.dto.request.customer.CustomerRequest;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import com.qnbeyond.customermanagement.repository.CustomerCommandRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCommandServiceImpl implements CustomerCommandService {

    private final CustomerCommandRepository customerCommandRepository;
    private final CustomerQueryService customerQueryService;
    private final PasswordEncoder passwordEncoder;

    private final CustomerRequestMapper mapper = Mappers.getMapper(CustomerRequestMapper.class);

    @Override
    public CustomerEntity create(CustomerRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        CustomerEntity customerEntity = mapper.map(request);
        return customerCommandRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity update(Long id, CustomerRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

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
