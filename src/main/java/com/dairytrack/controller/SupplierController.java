package com.dairytrack.controller;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.SupplierRequestDto;
import com.dairytrack.dto.SupplierResponseDto;
import com.dairytrack.model.User;
import com.dairytrack.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponseDto<SupplierResponseDto>> createSupplier(@Valid @RequestBody
                                                          SupplierRequestDto supplierRequestDto
                                                         , @AuthenticationPrincipal User user){
        return new ResponseEntity<>(supplierService.createSupplier(supplierRequestDto,user),HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponseDto<List<SupplierResponseDto>>> getAllSuppliers(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(supplierService.getAllSuppliers(user), HttpStatus.OK);
    }

    @PutMapping("/update/{supplierId}")
    public ResponseEntity<ApiResponseDto<SupplierResponseDto>> updateSupplierById(@PathVariable Long supplierId
                                            , @Valid @RequestBody SupplierRequestDto supplierRequestDto
                                                              , @AuthenticationPrincipal User user){
        return new ResponseEntity<>(supplierService.updateSupplierById(supplierId,supplierRequestDto,user),
                                                                                      HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponseDto<SupplierResponseDto>> deleteSupplierById(@PathVariable("id") Long supplierId){
        return new ResponseEntity<>(supplierService.deleteSupplierById(supplierId),HttpStatus.OK);
    }

    @GetMapping("/getSupplierCount")
    public ResponseEntity<ApiResponseDto<Long>> getSupplierCount(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(supplierService.getSupplierCount(user),HttpStatus.OK);
    }


}
