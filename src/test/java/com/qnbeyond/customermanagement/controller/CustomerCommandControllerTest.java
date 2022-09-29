package com.qnbeyond.customermanagement.controller;

import com.qnbeyond.customermanagement.controller.customer.CustomerCommandController;
import com.qnbeyond.customermanagement.model.dto.request.CustomerRequestBuilder;
import com.qnbeyond.customermanagement.model.dto.request.customer.CustomerRequest;
import com.qnbeyond.customermanagement.model.entity.Customer;
import com.qnbeyond.customermanagement.model.entity.CustomerBuilder;
import com.qnbeyond.customermanagement.service.customer.CustomerCommandService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = CustomerCommandController.class)
class CustomerCommandControllerTest extends AbstractControllerTest {
    @MockBean
    private CustomerCommandService customerCommandService;

    private static final String CUSTOMER_ENDPOINT = "/api/v1/customer";
    private static final String PATH_VARIABLE_ID_ENDPOINT = CUSTOMER_ENDPOINT + "/{id}";

    @Test
    void givenValidCustomerRequest_whenCreateCustomer_thenReturnCustomerResponse() {
        CustomerRequest customerRequest = CustomerRequestBuilder.getValidCustomerRequest();
        Customer customer = CustomerBuilder.getValidCustomer();
        when(customerCommandService.create(any(CustomerRequest.class))).thenReturn(customer);

        client.post()
                .uri(CUSTOMER_ENDPOINT)
                .bodyValue(customerRequest)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.success").isEqualTo(true)
                .jsonPath("$.errorMessage").isEmpty()
                .jsonPath("$.data").isNotEmpty();
    }

    @Test
    void givenValidCustomerRequest_whenUpdateCustomer_thenReturnCustomerResponse() {
        CustomerRequest customerRequest = CustomerRequestBuilder.getValidCustomerRequest();
        Customer customer = CustomerBuilder.getValidCustomer();
        when(customerCommandService.update(anyLong(), any(CustomerRequest.class))).thenReturn(customer);

        client.put()
                .uri(PATH_VARIABLE_ID_ENDPOINT, customer.getId())
                .bodyValue(customerRequest)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.success").isEqualTo(true)
                .jsonPath("$.errorMessage").isEmpty()
                .jsonPath("$.data").isNotEmpty();
    }

    @Test
    void givenValidCustomerRequest_whenDeleteCustomer_thenReturnCustomerResponse() {
        Customer customer = CustomerBuilder.getValidCustomer();
        when(customerCommandService.delete(anyLong())).thenReturn(customer);

        client.delete()
                .uri(PATH_VARIABLE_ID_ENDPOINT, customer.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.success").isEqualTo(true)
                .jsonPath("$.errorMessage").isEmpty()
                .jsonPath("$.data").isNotEmpty();
    }
}
