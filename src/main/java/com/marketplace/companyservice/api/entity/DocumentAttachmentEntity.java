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
@NoArgsConstructor
@Data
public class DocumentAttachmentEntity {

    @Id
    @NonNull
    @Column
    private UUID id;
    @NonNull
    @Column
    private String name;

    /** размеер файла не более 32Мб */
    @NonNull
    @Column
    @Max(value = 32)
    private Byte size;
    @NonNull
    @Column(name = "document_format")
    @Enumerated(EnumType.STRING)
    private FormatDocEnum formatDocument;
    @Column(name = "document_type")
    @Enumerated(EnumType.STRING)
    private TypeDocEnum typeDocument;

}
