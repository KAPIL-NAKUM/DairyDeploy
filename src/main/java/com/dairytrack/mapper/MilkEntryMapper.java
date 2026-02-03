package com.dairytrack.mapper;

import com.dairytrack.dto.MilkEntryRequestDto;
import com.dairytrack.dto.MilkEntryResponseDto;
import com.dairytrack.model.MilkEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MilkEntryMapper {

    MilkEntryResponseDto toDto(MilkEntry milkEntry);

    MilkEntry toEntity(MilkEntryRequestDto milkEntryRequestDto);

}
