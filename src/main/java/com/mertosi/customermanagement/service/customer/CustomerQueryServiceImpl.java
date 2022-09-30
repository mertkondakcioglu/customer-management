package com.mertosi.customermanagement.service.customer;

import com.mertosi.customermanagement.common.exception.NotFoundException;
import com.mertosi.customermanagement.model.entity.Customer;
import com.mertosi.customermanagement.repository.customer.CustomerQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final CustomerQueryRepository customerQueryRepository;

    @Override
    public List<Customer> getAll() {
        return customerQueryRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerQueryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }

    @Override
    public Customer getByEmail(String email) {
        return customerQueryRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(email));
    }
}
