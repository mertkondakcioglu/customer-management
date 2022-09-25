package com.qnbeyond.customermanagement.controller.customer;

import com.qnbeyond.customermanagement.common.mapper.CustomerResponseMapper;
import com.qnbeyond.customermanagement.model.dto.request.customer.CustomerRequest;
import com.qnbeyond.customermanagement.model.dto.response.BaseResponse;
import com.qnbeyond.customermanagement.model.dto.response.customer.CustomerResponse;
import com.qnbeyond.customermanagement.service.customer.CustomerCommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Customer")
public class CustomerCommandController {
    private final CustomerCommandService customerCommandService;
    private final CustomerResponseMapper mapper = Mappers.getMapper(CustomerResponseMapper.class);

    @PostMapping
    @ApiOperation(value = "Create Customer")
    public BaseResponse<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerCommandService.create(request)))
                .build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Customer")
    public BaseResponse<CustomerResponse> update(@PathVariable @NotNull Long id, @RequestBody @Valid CustomerRequest request) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerCommandService.update(id, request)))
                .build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Customer")
    public BaseResponse<CustomerResponse> delete(@PathVariable @NotNull Long id) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerCommandService.delete(id)))
                .build();
    }
}
