package com.dairytrack.controller;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.MilkRateRequestDto;
import com.dairytrack.dto.MilkRateResponseDto;
import com.dairytrack.model.User;
import com.dairytrack.service.MilkRateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/milkRate")
public class MilkRateController {

    private final MilkRateService milkRateService;

    public MilkRateController(MilkRateService milkRateService) {
        this.milkRateService = milkRateService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponseDto<MilkRateResponseDto>> addMilkRate(@Valid @RequestBody
                                                                     MilkRateRequestDto milkRateRequestDto
                                                                   , @AuthenticationPrincipal User user){
        return new ResponseEntity<>(milkRateService.addMilkRate(milkRateRequestDto, user), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponseDto<MilkRateResponseDto>> updateMilkRate(@Valid @RequestBody
                                                                       MilkRateRequestDto milkRateRequestDto
            , @AuthenticationPrincipal User user){
        return new ResponseEntity<>(milkRateService.updateMilkRate(milkRateRequestDto, user),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponseDto<MilkRateResponseDto>> getMilkRate(@AuthenticationPrincipal User user){
        return  new ResponseEntity<>(milkRateService.getMilkRate(user),HttpStatus.OK);
    }
}
