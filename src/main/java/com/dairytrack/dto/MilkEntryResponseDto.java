package com.dairytrack.dto;

import com.dairytrack.enums.Shift;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MilkEntryResponseDto {

    private Double fat;

    private Double lr;

    private Double quantity;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    private Double ratePerLtr;

    private Double totalAmount;

}
