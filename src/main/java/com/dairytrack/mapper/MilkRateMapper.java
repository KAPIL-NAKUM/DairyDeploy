package com.dairytrack.mapper;

import com.dairytrack.dto.MilkRateRequestDto;
import com.dairytrack.dto.MilkRateResponseDto;
import com.dairytrack.model.MilkRate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MilkRateMapper {
    MilkRate toEntity(MilkRateRequestDto milkRateRequestDto);

    MilkRateResponseDto toDto(MilkRate milkRate);
}
