package com.dairytrack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UnauthorizedResponseDto {
    private boolean success;
    private int status;
    private String error;
    private String path;
    //private LocalDateTime timestamp;

    public UnauthorizedResponseDto(int status, String error, String path) {
        this.success = false;
        this.status = status;
        this.error = error;
        this.path = path;
        //this.timestamp = LocalDateTime.now();
    }
}
