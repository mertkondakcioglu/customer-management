package com.qnbeyond.customermanagement.service;

import com.qnbeyond.customermanagement.common.exception.NotFoundException;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import com.qnbeyond.customermanagement.repository.CustomerQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final CustomerQueryRepository customerQueryRepository;

    @Override
    public List<CustomerEntity> getAll() {
        return customerQueryRepository.findAll();
    }

    @Override
    public CustomerEntity getById(Long id) {
        return customerQueryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }
}
