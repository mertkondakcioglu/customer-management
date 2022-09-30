package com.mertosi.customermanagement.service;

import com.mertosi.customermanagement.model.dto.request.CustomerRequestBuilder;
import com.mertosi.customermanagement.model.dto.request.customer.CustomerRequest;
import com.mertosi.customermanagement.model.entity.Customer;
import com.mertosi.customermanagement.model.entity.CustomerBuilder;
import com.mertosi.customermanagement.repository.customer.CustomerCommandRepository;
import com.mertosi.customermanagement.service.customer.CustomerCommandServiceImpl;
import com.mertosi.customermanagement.service.customer.CustomerQueryService;
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
    void givenValidCustomerRequest_whenCreateCustomer_thenReturnCustomer() {
        CustomerRequest testCustomerRequest = CustomerRequestBuilder.getValidCustomerRequest();
        Customer testCustomer = CustomerBuilder.getValidCustomer();

        when(customerCommandRepository.save(any(Customer.class))).thenReturn(testCustomer);
        Customer customer = customerCommandService.create(testCustomerRequest);

        assertThat(testCustomer).isEqualTo(customer);
    }

    @Test
    void givenValidCustomerRequest_whenUpdateCustomer_thenReturnCustomer() {
        CustomerRequest testCustomerRequest = CustomerRequestBuilder.getValidCustomerRequest();
        Customer testCustomer = CustomerBuilder.getValidCustomer();

        when(customerQueryService.getById(anyLong())).thenReturn(testCustomer);
        when(customerCommandRepository.save(any(Customer.class))).thenReturn(testCustomer);
        Customer customer = customerCommandService.update(testCustomer.getId(), testCustomerRequest);

        assertThat(testCustomer).isEqualTo(customer);
    }

    @Test
    void givenValidCustomerRequest_whenDeleteCustomer_thenReturnCustomer() {
        Customer testCustomer = CustomerBuilder.getValidCustomer();

        when(customerQueryService.getById(anyLong())).thenReturn(testCustomer);
        customerCommandService.delete(testCustomer.getId());

        verify(customerCommandRepository, times(1)).delete(any(Customer.class));
    }
}
