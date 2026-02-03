package com.dairytrack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String phone;

    private String address;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<MilkEntry> milkEntries;
}
