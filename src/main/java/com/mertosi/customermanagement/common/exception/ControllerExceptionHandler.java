package com.mertosi.customermanagement.common.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.mertosi.customermanagement.model.dto.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomerManagementException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public BaseResponse<Object> onCustomerManagementException(CustomerManagementException e) {
        log.error(e.getMessage(), e);

        return BaseResponse.builder()
                .success(false)
                .errorMessage(e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);

        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return BaseResponse.builder()
                .success(false)
                .errorMessage(errorMessage)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message;
        if (e.getCause() instanceof InvalidFormatException invalidFormatException) {
            message = String.format("value: %s is invalid for type: %s",
                    invalidFormatException.getValue(),
                    invalidFormatException.getTargetType().getSimpleName());
        } else message = "Bad Request";

        log.error(message);

        return BaseResponse.builder()
                .success(false)
                .errorMessage(message)
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> handleValidation(ConstraintViolationException e) {
        log.error(e.getMessage(), e);

        String errorMessage = e.getConstraintViolations().stream()
                .map(error -> error.getPropertyPath().toString() + " " + error.getMessage())
                .collect(Collectors.joining(", "));

        return BaseResponse.builder()
                .success(false)
                .errorMessage(errorMessage)
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Object> onDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error(e.getMessage(), e);

        return BaseResponse.builder()
                .success(false)
                .errorMessage(Objects.requireNonNull(e.getRootCause()).getMessage())
                .build();
    }
}
