package com.dairytrack.dto;

import com.dairytrack.enums.Shift;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MilkEntryRequestDto {

    private Double fat;

    private Double lr;

    private Double quantity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Shift shift;
}
