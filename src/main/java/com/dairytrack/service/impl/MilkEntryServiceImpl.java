package com.dairytrack.service.impl;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.MilkEntryRequestDto;
import com.dairytrack.dto.MilkEntryResponseDto;
import com.dairytrack.exception.SupplierNotFoundException;
import com.dairytrack.mapper.MilkEntryMapper;
import com.dairytrack.model.MilkEntry;
import com.dairytrack.model.Supplier;
import com.dairytrack.model.User;
import com.dairytrack.repository.MilkEntryRepository;
import com.dairytrack.repository.MilkRateRepository;
import com.dairytrack.repository.SupplierRepository;
import com.dairytrack.service.MilkEntryService;
import org.springframework.stereotype.Service;

@Service
public class MilkEntryServiceImpl implements MilkEntryService {

    private final SupplierRepository supplierRepository;
    private final MilkRateRepository milkRateRepository;
    private final MilkEntryRepository milkEntryRepository;
    private final MilkEntryMapper milkEntryMapper;

    public MilkEntryServiceImpl(SupplierRepository supplierRepository,MilkRateRepository milkRateRepository
                                ,MilkEntryMapper milkEntryMapper
    ,MilkEntryRepository milkEntryRepository){
        this.supplierRepository = supplierRepository;
        this.milkRateRepository = milkRateRepository;
        this.milkEntryRepository = milkEntryRepository;
        this.milkEntryMapper = milkEntryMapper;
    }

    @Override
    public ApiResponseDto<MilkEntryResponseDto> addMilkEntry(Long supplierId, MilkEntryRequestDto
            milkEntryRequestDto, User user) {

       Supplier supplier = supplierRepository.findByIdAndUserId(supplierId,user.getId())
               .orElseThrow(()-> new SupplierNotFoundException("Supplier with id "+supplierId+" " +
                       "is not found or Supplier is not Yours"));

       Double fat = milkEntryRequestDto.getFat();
       Double quantity = milkEntryRequestDto.getQuantity();
       Double ratePerFat = milkRateRepository.getMilkRateByUser(user.getId());
       Double totalAmount = fat*ratePerFat*quantity;

       MilkEntry milkEntry = milkEntryMapper.toEntity(milkEntryRequestDto);
       milkEntry.setRatePerLtr(ratePerFat*fat);
       milkEntry.setTotalAmount(totalAmount);
       milkEntry.setSupplier(supplier);
       MilkEntry savedMilkEntry = milkEntryRepository.save(milkEntry);
       MilkEntryResponseDto milkEntryResponseDto = milkEntryMapper.toDto(savedMilkEntry);

        return new ApiResponseDto<>("Milk Entry Added Successfully", milkEntryResponseDto);
    }

//    @Override
//    public ApiResponseDto<MilkEntryResponseDto> deleteMilkEntry(Long milkEntryId, User user) {
//
//        return new ApiResponseDto<>("Milk Entry Deleted Successfully", milkEntryResponseDto);
//    }
}
