package com.dairytrack.mapper;

import com.dairytrack.dto.SupplierRequestDto;
import com.dairytrack.dto.SupplierResponseDto;
import com.dairytrack.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier toEntity(SupplierRequestDto supplierRequestDto);

    SupplierResponseDto toDto(Supplier supplier);
}
