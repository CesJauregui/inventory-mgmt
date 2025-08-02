package com.mgmtInventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String RUC;
    private String contact;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String country;
    private String paymentTerms;
    private String note;
    private Boolean active;
}
