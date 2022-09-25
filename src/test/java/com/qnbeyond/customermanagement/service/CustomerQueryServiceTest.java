package com.qnbeyond.customermanagement.service;

import com.qnbeyond.customermanagement.common.exception.NotFoundException;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import com.qnbeyond.customermanagement.model.entity.CustomerEntityBuilder;
import com.qnbeyond.customermanagement.repository.CustomerQueryRepository;
import com.qnbeyond.customermanagement.service.customer.CustomerQueryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CustomerQueryServiceTest extends AbstractUnitTest {

    @InjectMocks
    CustomerQueryServiceImpl customerQueryService;

    @Mock
    private CustomerQueryRepository customerQueryRepository;

    @Test
    void happyPath_getAll() {
        List<CustomerEntity> testCustomerBagEntities = Collections.singletonList(CustomerEntityBuilder.getValidCustomerEntity());
        when(customerQueryRepository.findAll()).thenReturn(testCustomerBagEntities);

        List<CustomerEntity> customerBagEntities = customerQueryService.getAll();
        assertThat(testCustomerBagEntities).isEqualTo(customerBagEntities);
    }

    @Test
    void givenValidId_whenGetCustomerEntity_thenReturnCustomerEntity() {
        CustomerEntity testCustomerEntity = CustomerEntityBuilder.getValidCustomerEntity();
        when(customerQueryRepository.findById(testCustomerEntity.getId())).thenReturn(Optional.of(testCustomerEntity));

        CustomerEntity CustomerEntity = customerQueryService.getById(testCustomerEntity.getId());
        assertThat(testCustomerEntity).isEqualTo(CustomerEntity);
    }

    @Test
    void givenInvalidId_whenGetCustomerEntity_thenThrowNotFoundException() {
        Long id = 2L;
        assertThrows(NotFoundException.class, () -> customerQueryService.getById(id));
    }
}
