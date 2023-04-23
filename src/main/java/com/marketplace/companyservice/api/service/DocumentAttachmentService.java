package com.marketplace.companyservice.api.service;

import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;

/** Интерфейс для сервиса document_attachment */

public interface DocumentAttachmentService {

    void saveDocAttach(DocumentAttachmentRequestDto documentAttachment);
}
