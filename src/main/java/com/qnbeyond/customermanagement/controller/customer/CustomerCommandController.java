package com.qnbeyond.customermanagement.controller.customer;

import com.qnbeyond.customermanagement.common.mapper.CustomerResponseMapper;
import com.qnbeyond.customermanagement.model.dto.request.customer.CustomerRequest;
import com.qnbeyond.customermanagement.model.dto.response.BaseResponse;
import com.qnbeyond.customermanagement.model.dto.response.customer.CustomerResponse;
import com.qnbeyond.customermanagement.service.customer.CustomerCommandService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@PreAuthorize("hasRole(T(com.qnbeyond.customermanagement.common.util.CustomerManagementConstants).USER)")
public class CustomerCommandController {
    private final CustomerCommandService customerCommandService;
    private final CustomerResponseMapper mapper = Mappers.getMapper(CustomerResponseMapper.class);

    @PostMapping
    public BaseResponse<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerCommandService.create(request)))
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<CustomerResponse> update(@PathVariable @NotNull Long id, @RequestBody @Valid CustomerRequest request) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerCommandService.update(id, request)))
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<CustomerResponse> delete(@PathVariable @NotNull Long id) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerCommandService.delete(id)))
                .build();
    }
}
