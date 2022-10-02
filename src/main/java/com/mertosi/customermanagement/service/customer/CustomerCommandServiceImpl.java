package com.mertosi.customermanagement.service.customer;

import com.mertosi.customermanagement.common.mapper.customer.CustomerRequestMapper;
import com.mertosi.customermanagement.model.dto.request.customer.CustomerRequest;
import com.mertosi.customermanagement.model.entity.Customer;
import com.mertosi.customermanagement.repository.customer.CustomerCommandRepository;
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
    public Customer create(CustomerRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        Customer customer = mapper.map(request);
        return customerCommandRepository.save(customer);
    }

    @Override
    public Customer update(Long id, CustomerRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        Customer customerToUpdated = customerQueryService.getById(id);
        mapper.requestToEntity(request, customerToUpdated);

        return customerCommandRepository.save(customerToUpdated);
    }

    @Override
    public Customer delete(Long id) {
        Customer customerToDeleted = customerQueryService.getById(id);
        customerCommandRepository.delete(customerToDeleted);

        return customerToDeleted;
    }
}
