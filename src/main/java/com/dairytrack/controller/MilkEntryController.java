package com.dairytrack.controller;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.MilkEntryRequestDto;
import com.dairytrack.dto.MilkEntryResponseDto;
import com.dairytrack.model.User;
import com.dairytrack.service.MilkEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/milkEntry")
public class MilkEntryController {

    private final MilkEntryService milkEntryService;

    public MilkEntryController(MilkEntryService milkEntryService){

        this.milkEntryService = milkEntryService;
    }

    @PostMapping("/add/{supplierId}")
    public ResponseEntity<ApiResponseDto<MilkEntryResponseDto>> addMilk(@PathVariable Long supplierId,
                                                                        @RequestBody MilkEntryRequestDto milkEntryRequestDto
                                                            , @AuthenticationPrincipal User user){
        return new ResponseEntity<>(milkEntryService.addMilkEntry(supplierId,milkEntryRequestDto,user), HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{milkEntryId}")
//    public ResponseEntity<ApiResponseDto<MilkEntryResponseDto>> deleteMilkEntry(@PathVariable Long milkEntryId,
//                                                                   @AuthenticationPrincipal User user){
//        return new ResponseEntity<>(milkEntryService.deleteMilkEntry(milkEntryId,user), HttpStatus.OK);
//    }

}
