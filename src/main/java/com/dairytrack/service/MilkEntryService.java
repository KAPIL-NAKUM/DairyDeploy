package com.dairytrack.service;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.MilkEntryRequestDto;
import com.dairytrack.dto.MilkEntryResponseDto;
import com.dairytrack.model.User;

public interface MilkEntryService {
    public ApiResponseDto<MilkEntryResponseDto> addMilkEntry(Long supplierId, MilkEntryRequestDto
            milkEntryRequestDto, User user);

   // public ApiResponseDto<MilkEntryResponseDto> deleteMilkEntry(Long milkEntryId, User user);
}
