package com.marketplace.companyservice.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import java.util.List;
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
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "rating", columnDefinition = "NUMERIC(5,2)")
    private Double rating;

    @Column(name = "main_category")
    @NonNull
    private String mainCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id", columnDefinition = "company_id")
    private PictureEntity picture;

    @Column(name = "legal_name")
    @NonNull
    private String legalName;

    @Column(name = "type")
    @NonNull
    private String type;

    @Column(name = "inn")
    @NonNull
    private String inn;

    @Column(name = "is_active")
    @NonNull
    private Boolean isActive;

    @OneToMany
    @JoinColumn(name="company_information_id")
    private List<DocumentAttachmentEntity> documentAttachment;
}
