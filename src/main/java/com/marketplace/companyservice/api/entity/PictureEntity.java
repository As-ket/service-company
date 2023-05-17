package com.marketplace.companyservice.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * Таблица для хранения аватарки-картинки магазина.
 */

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "picture", schema = "company")
public class PictureEntity {

    @Id
    @Column(name = "company_id")
    private UUID id;

    @Column(name = "picture")
    private Byte[] picture;
}
