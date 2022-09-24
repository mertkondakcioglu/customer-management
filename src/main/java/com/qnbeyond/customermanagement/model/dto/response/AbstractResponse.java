package com.qnbeyond.customermanagement.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
