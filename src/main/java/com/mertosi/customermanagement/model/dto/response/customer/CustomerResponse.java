package com.mertosi.customermanagement.model.dto.response.customer;

import com.mertosi.customermanagement.model.dto.response.AbstractResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse extends AbstractResponse {
    private String email;
    private String firstName;
    private String lastName;
}
