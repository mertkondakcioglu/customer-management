package com.qnbeyond.customermanagement.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse extends AbstractResponse {
    private String email;
    private String firstName;
    private String lastName;
}
