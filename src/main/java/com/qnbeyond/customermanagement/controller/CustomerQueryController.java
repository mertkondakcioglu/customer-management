package com.qnbeyond.customermanagement.controller;

import com.qnbeyond.customermanagement.common.mapper.CustomerResponseMapper;
import com.qnbeyond.customermanagement.model.dto.response.BaseResponse;
import com.qnbeyond.customermanagement.model.dto.response.CustomerResponse;
import com.qnbeyond.customermanagement.service.CustomerQueryService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
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
@Validated
public class CustomerQueryController {
    private final CustomerQueryService customerQueryService;
    private final CustomerResponseMapper mapper = Mappers.getMapper(CustomerResponseMapper.class);

    @GetMapping
    public BaseResponse<List<CustomerResponse>> getAll() {
        return BaseResponse.<List<CustomerResponse>>builder()
                .data(mapper.map(customerQueryService.getAll()))
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<CustomerResponse> getById(@PathVariable @NotNull Long id) {
        return BaseResponse.<CustomerResponse>builder()
                .data(mapper.map(customerQueryService.getById(id)))
                .build();
    }
}
