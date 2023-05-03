package com.marketplace.companyservice.api.repository;

import com.marketplace.companyservice.api.entity.DocumentAttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с document_attachment
 */
public interface DocumentAttachmentRepository extends JpaRepository<DocumentAttachmentEntity,UUID> {

}
