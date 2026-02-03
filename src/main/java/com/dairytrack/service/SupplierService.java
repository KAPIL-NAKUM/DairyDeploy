package com.dairytrack.service;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.SupplierRequestDto;
import com.dairytrack.dto.SupplierResponseDto;
import com.dairytrack.model.User;

import java.util.List;

public interface SupplierService {
     ApiResponseDto<SupplierResponseDto> createSupplier(SupplierRequestDto supplierRequestDto, User user);

     ApiResponseDto<List<SupplierResponseDto>> getAllSuppliers(User user);

     ApiResponseDto<SupplierResponseDto> deleteSupplierById(Long supplierId);

     ApiResponseDto<SupplierResponseDto> updateSupplierById(Long supplierId, SupplierRequestDto supplierRequestDto, User user);

     ApiResponseDto<Long> getSupplierCount(User user);
}
