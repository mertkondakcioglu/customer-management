package com.qnbeyond.customermanagement.service;

import com.qnbeyond.customermanagement.model.dto.request.CustomerRequestBuilder;
import com.qnbeyond.customermanagement.model.dto.request.customer.CustomerRequest;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import com.qnbeyond.customermanagement.model.entity.CustomerEntityBuilder;
import com.qnbeyond.customermanagement.repository.CustomerCommandRepository;
import com.qnbeyond.customermanagement.service.customer.CustomerCommandServiceImpl;
import com.qnbeyond.customermanagement.service.customer.CustomerQueryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class CustomerCommandServiceTest extends AbstractUnitTest {

    @InjectMocks
    CustomerCommandServiceImpl customerCommandService;

    @Mock
    private CustomerCommandRepository customerCommandRepository;

    @Mock
    private CustomerQueryService customerQueryService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void givenValidCustomerRequest_whenCreateCustomerEntity_thenReturnCustomerEntity() {
        CustomerRequest testCustomerRequest = CustomerRequestBuilder.getValidCustomerRequest();
        CustomerEntity testCustomerEntity = CustomerEntityBuilder.getValidCustomerEntity();

        when(customerCommandRepository.save(any(CustomerEntity.class))).thenReturn(testCustomerEntity);
        CustomerEntity customerEntity = customerCommandService.create(testCustomerRequest);

        assertThat(testCustomerEntity).isEqualTo(customerEntity);
    }

    @Test
    void givenValidCustomerRequest_whenUpdateCustomerEntity_thenReturnCustomerEntity() {
        CustomerRequest testCustomerRequest = CustomerRequestBuilder.getValidCustomerRequest();
        CustomerEntity testCustomerEntity = CustomerEntityBuilder.getValidCustomerEntity();

        when(customerQueryService.getById(anyLong())).thenReturn(testCustomerEntity);
        when(customerCommandRepository.save(any(CustomerEntity.class))).thenReturn(testCustomerEntity);
        CustomerEntity customerEntity = customerCommandService.update(testCustomerEntity.getId(), testCustomerRequest);

        assertThat(testCustomerEntity).isEqualTo(customerEntity);
    }

    @Test
    void givenValidCustomerRequest_whenDeleteCustomerEntity_thenReturnCustomerEntity() {
        CustomerEntity testCustomerEntity = CustomerEntityBuilder.getValidCustomerEntity();

        when(customerQueryService.getById(anyLong())).thenReturn(testCustomerEntity);
        customerCommandService.delete(testCustomerEntity.getId());

        verify(customerCommandRepository, times(1)).delete(any(CustomerEntity.class));
    }
}
