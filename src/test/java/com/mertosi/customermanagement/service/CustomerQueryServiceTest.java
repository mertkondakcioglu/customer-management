package com.mertosi.customermanagement.service;

import com.mertosi.customermanagement.common.exception.NotFoundException;
import com.mertosi.customermanagement.model.entity.Customer;
import com.mertosi.customermanagement.model.entity.CustomerBuilder;
import com.mertosi.customermanagement.repository.customer.CustomerQueryRepository;
import com.mertosi.customermanagement.service.customer.CustomerQueryServiceImpl;
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
        List<Customer> testCustomerBagEntities = Collections.singletonList(CustomerBuilder.getValidCustomer());
        when(customerQueryRepository.findAll()).thenReturn(testCustomerBagEntities);

        List<Customer> customerBagEntities = customerQueryService.getAll();
        assertThat(testCustomerBagEntities).isEqualTo(customerBagEntities);
    }

    @Test
    void givenValidId_whenGetCustomer_thenReturnCustomer() {
        Customer testCustomer = CustomerBuilder.getValidCustomer();
        when(customerQueryRepository.findById(testCustomer.getId())).thenReturn(Optional.of(testCustomer));

        Customer Customer = customerQueryService.getById(testCustomer.getId());
        assertThat(testCustomer).isEqualTo(Customer);
    }

    @Test
    void givenInvalidId_whenGetCustomer_thenThrowNotFoundException() {
        Long id = 2L;
        assertThrows(NotFoundException.class, () -> customerQueryService.getById(id));
    }
}
