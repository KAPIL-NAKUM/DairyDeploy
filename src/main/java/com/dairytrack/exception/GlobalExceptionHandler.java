package com.dairytrack.exception;

import com.dairytrack.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SupplierAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDto<Object>> handleSupplierAlreadyExistsException(SupplierAlreadyExistsException ex){
        ApiResponseDto<Object> apiResponseDto = new ApiResponseDto<>(ex.getMessage(),null);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<ApiResponseDto<Object>> handleSupplierNotFoundException(SupplierNotFoundException ex){
        ApiResponseDto<Object> apiResponseDto = new ApiResponseDto<>(ex.getMessage(),null);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<ApiResponseDto<Object>> handleEmailAlreadyRegisteredException(EmailAlreadyRegisteredException ex){
        ApiResponseDto<Object> apiResponseDto = new ApiResponseDto<>(ex.getMessage(),null);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.NOT_FOUND);
    }

}
