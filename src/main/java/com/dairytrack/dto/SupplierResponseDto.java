package com.dairytrack.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SupplierResponseDto {

     private Long id;

     private String email;

     private String name;

     private String phone;

     private String address;
}
