package com.marketplace.companyservice.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность  продавца.
 */
@Entity
@Table(name = "seller", schema = "company")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class SellerEntity {
    @Id
    @GeneratedValue
    @Column
    @NonNull
    private UUID id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String surname;

    @Column
    @NonNull
    private String email;

    @Column(name = "registration_date")
    @NonNull
    private LocalDateTime registrationDate;

    @OneToOne
    @JoinColumn(name="company_information_id")
    private CompanyInformationEntity companyInformation;
}
