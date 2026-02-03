package com.dairytrack.service;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.MilkRateRequestDto;
import com.dairytrack.dto.MilkRateResponseDto;
import com.dairytrack.model.User;

public interface MilkRateService {

    ApiResponseDto<MilkRateResponseDto> addMilkRate(MilkRateRequestDto milkRateRequestDto, User user);

    ApiResponseDto<MilkRateResponseDto> updateMilkRate(MilkRateRequestDto milkRateRequestDto, User user);

    ApiResponseDto<MilkRateResponseDto> getMilkRate(User user);
}
