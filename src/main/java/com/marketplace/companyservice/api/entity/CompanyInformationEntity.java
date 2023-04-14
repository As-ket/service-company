package com.marketplace.companyservice.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Сущность информации о компании.
 */
@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "company_information", schema = "company")
public class CompanyInformationEntity {
    @Id
    @Column(name = "id")
    private UUID id;    //    UUID пользователя

    @Column(name = "name")
    @NonNull
    private String name;    //    название магазина

    @Column(name = "rating", columnDefinition = "NUMERIC(5,2)")
    private Double rating;    //  рейтинг магазина

    @Column(name = "main_category")
    @NonNull
    private String mainCategory;    //  основная категория товаров

    @Column(name = "picture")
    private Byte[] picture;    //  картинка-аватарка магазина

    @Column(name = "legal_name")
    @NonNull
    private String legalName;    //  юр. название компании

    @Column(name = "type")
    @NonNull
    private String type;    //  тип организации

    @Column(name = "inn")
    @NonNull
    private String inn;    //  инн

    @Column(name = "is_active")
    @NonNull
    private Boolean isActive;    //  призак работы
}
