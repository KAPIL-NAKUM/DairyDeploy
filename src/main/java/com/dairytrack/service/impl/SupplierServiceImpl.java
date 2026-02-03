package com.dairytrack.service.impl;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.SupplierRequestDto;
import com.dairytrack.dto.SupplierResponseDto;
import com.dairytrack.exception.SupplierAlreadyExistsException;
import com.dairytrack.exception.SupplierNotFoundException;
import com.dairytrack.mapper.SupplierMapper;
import com.dairytrack.model.Supplier;
import com.dairytrack.model.User;
import com.dairytrack.repository.SupplierRepository;
import com.dairytrack.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;



    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public ApiResponseDto<SupplierResponseDto> createSupplier(SupplierRequestDto supplierRequestDto, User user) {
        if(supplierRepository.findByEmail(supplierRequestDto.getEmail()).isPresent()){
            throw new SupplierAlreadyExistsException("Supplier with email id "+supplierRequestDto.getEmail()+" already exists");
        }

        Supplier supplier = supplierMapper.toEntity(supplierRequestDto);
        supplier.setUser(user);
        Supplier savedSupplier = supplierRepository.save(supplier);
        SupplierResponseDto supplierResponseDto = supplierMapper.toDto(savedSupplier);
        return new ApiResponseDto<>("Supplier Added Successfully",supplierResponseDto);
    }

    @Override
    public ApiResponseDto<List<SupplierResponseDto>> getAllSuppliers(User user){

        supplierRepository.findByUser(user)
                .orElseThrow(()-> new SupplierNotFoundException("No supplier added"));

        Optional<List<Supplier>> optionalSupplierList = supplierRepository.findByUser(user);
        List<Supplier> supplierList = optionalSupplierList.get();
        List<SupplierResponseDto> supplierResponseDtoList = supplierList.stream()
                .map(supplierMapper::toDto)
                .collect(Collectors.toList());

       return new ApiResponseDto<>("Suppliers fetched successfully",supplierResponseDtoList);

    }

    @Override
    public ApiResponseDto<SupplierResponseDto> deleteSupplierById(Long supplierId){

        Supplier supplier = supplierRepository.findById(supplierId)
         .orElseThrow(()-> new SupplierNotFoundException("Supplier with id "+supplierId+" is not present"));

         supplierRepository.deleteById(supplierId);
        SupplierResponseDto deletedSupplierResponseDto = supplierMapper.toDto(supplier);
        return new ApiResponseDto<>("Supplier deleted successfully", deletedSupplierResponseDto);
    }

    @Override
    public ApiResponseDto<SupplierResponseDto> updateSupplierById(Long supplierId, SupplierRequestDto supplierRequestDto, User user){

        Supplier existingSupplier = supplierRepository.findByIdAndUserId(supplierId,user.getId())
                .orElseThrow(()-> new SupplierNotFoundException("Supplier with id "+supplierId+" " +
                                                               "is not found or Supplier is not Yours"));

        Supplier supplierToUpdate  = supplierMapper.toEntity(supplierRequestDto);
        supplierToUpdate.setId(existingSupplier.getId());
        supplierToUpdate.setUser(existingSupplier.getUser());
        Supplier updatedSupplier = supplierRepository.save(supplierToUpdate);
        SupplierResponseDto updatedSupplierResponseDto = supplierMapper.toDto(updatedSupplier);

        return new ApiResponseDto<>("Supplier updated successfully",updatedSupplierResponseDto);
    }


    @Override
    public ApiResponseDto<Long> getSupplierCount(User user){

        Long supplierCount = supplierRepository.countByUser(user);
        return new ApiResponseDto<>("Supplier count fetched successfully",supplierCount);
    }

}
