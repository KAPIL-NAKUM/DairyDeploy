package com.dairytrack.service.impl;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.MilkRateRequestDto;
import com.dairytrack.dto.MilkRateResponseDto;
import com.dairytrack.mapper.MilkRateMapper;
import com.dairytrack.model.MilkRate;
import com.dairytrack.model.User;
import com.dairytrack.repository.MilkRateRepository;
import com.dairytrack.repository.UserRepository;
import com.dairytrack.service.MilkRateService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MilkRateServiceImpl implements MilkRateService {

    private final UserRepository userRepository;
    private final MilkRateMapper milkRateMapper;
    private final MilkRateRepository milkRateRepository;


    public MilkRateServiceImpl(UserRepository userRepository, MilkRateMapper milkRateMapper, MilkRateRepository milkRateRepository) {
        this.userRepository = userRepository;
        this.milkRateMapper = milkRateMapper;
        this.milkRateRepository = milkRateRepository;

    }

    @Override
    public ApiResponseDto<MilkRateResponseDto> addMilkRate(MilkRateRequestDto milkRateRequestDto, User user) {

        MilkRate milkRate = milkRateMapper.toEntity(milkRateRequestDto);
        System.out.println(milkRate.getPricePerFat());
        milkRate.setUser(user);
        MilkRate savedMilkRate = milkRateRepository.save(milkRate);
        MilkRateResponseDto milkRateResponseDto = milkRateMapper.toDto(savedMilkRate);
        return new ApiResponseDto<>("Milk rate added successfully",milkRateResponseDto);
    }

    @Override
    public ApiResponseDto<MilkRateResponseDto> updateMilkRate(MilkRateRequestDto milkRateRequestDto, User user) {

        MilkRate existingMilkRate = milkRateRepository.findByUser(user);

        MilkRate milkRateToUpdate = milkRateMapper.toEntity(milkRateRequestDto);
        milkRateToUpdate.setId(existingMilkRate.getId());
        milkRateToUpdate.setUser(user);
        MilkRate updatedMilkRate = milkRateRepository.save(milkRateToUpdate);
        MilkRateResponseDto milkRateResponseDto = milkRateMapper.toDto(updatedMilkRate);

        return new ApiResponseDto<>("Milk Rate Updated Successfully",milkRateResponseDto);
    }

    @Override
    public ApiResponseDto<MilkRateResponseDto> getMilkRate(User user){

        MilkRate existingMilkRate = milkRateRepository.findByUser(user);
        MilkRateResponseDto milkRateResponseDto = milkRateMapper.toDto(existingMilkRate);

        return new ApiResponseDto<>("Milk Rate Fetched Successfully",milkRateResponseDto);
    }
}
