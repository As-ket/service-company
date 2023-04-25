package com.marketplace.companyservice.api.entity;

import com.marketplace.companyservice.api.allEnums.FormatDocEnum;
import com.marketplace.companyservice.api.allEnums.TypeDocEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.UUID;

/**
 * Сущность описывающая приложение к документу.
 */

@Entity
@Table(name = "document_attachment", schema = "company")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class DocumentAttachmentEntity {

    @Id
    @Column
    @GeneratedValue
    private UUID id;
    @NonNull
    @Column
    private Byte[] value;
    @NonNull
    @Column
    private String name;
    @NonNull
    @Column
    @Max(value = 33554432) // размер файла не более 32Мб
    private Integer size;
    @NonNull
    @Column(name = "document_format")
    @Enumerated(EnumType.STRING)
    private FormatDocEnum formatDocument;
    @Column(name = "document_type")
    @Enumerated(EnumType.STRING)
    private TypeDocEnum typeDocument;

}
