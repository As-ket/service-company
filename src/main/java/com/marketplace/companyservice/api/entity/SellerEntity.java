package com.marketplace.companyservice.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность  продовца.
 */
@Entity
@Table(name = "seller", schema = "company")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerEntity {
    @Id
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
}
