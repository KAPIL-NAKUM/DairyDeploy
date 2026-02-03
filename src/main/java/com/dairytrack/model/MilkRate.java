package com.dairytrack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MilkRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double pricePerFat;

    @OneToOne
    @JoinColumn(unique = true, nullable = false)
    private User user;
}
