package com.dairytrack.model;
import com.dairytrack.enums.Shift;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class MilkEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double fat;

    private Double lr;

    private Double quantity;

    private LocalDate date;

    private Double ratePerLtr;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @ManyToOne
    private Supplier supplier;
}
