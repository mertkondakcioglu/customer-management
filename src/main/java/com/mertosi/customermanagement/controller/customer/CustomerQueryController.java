package com.mertosi.customermanagement.controller.customer;

import com.mertosi.customermanagement.common.mapper.CustomerResponseMapper;
import com.mertosi.customermanagement.model.dto.response.BaseResponse;
import com.mertosi.customermanagement.model.dto.response.customer.CustomerResponse;
import com.mertosi.customermanagement.service.customer.CustomerQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@PreAuthorize("hasRole(T(com.mertosi.customermanagement.common.util.CustomerManagementConstants).USER)")
@Api(tags = "Customer")
@Validated
public class CustomerQueryController {
    private final CustomerQueryService customerQueryService;
    private final CustomerResponseMapper mapper = Mappers.getMapper(CustomerResponseMapper.class);

    @GetMapping
    @ApiOperation(value = "Get All Customer")
    public BaseResponse<List<CustomerResponse>> getAll() {
        return BaseResponse.<List<CustomerResponse>>builder()
                .data(mapper.map(customerQueryService.getAll()))
                .build();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Customer By Id")
    public BaseResponse<CustomerResponse> getById(@PathVariable @NotNull Long id) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerQueryService.getById(id)))
                .build();
    }
}
