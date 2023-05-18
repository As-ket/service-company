package com.marketplace.companyservice.api.controller;

import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import com.marketplace.companyservice.api.resource.DocumentAttachmentResource;
import com.marketplace.companyservice.api.service.DocumentAttachmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с document_attachment
 */

@RestController
@AllArgsConstructor
@Slf4j
public class DocumentAttachmentController implements DocumentAttachmentResource {

    private final DocumentAttachmentService service;

    @Override
    public ResponseEntity<String> saveDocAttach(DocumentAttachmentRequestDto docFile) {
        try {
            service.saveDocAttach(docFile);
            log.info("Файл \"" + docFile.getName() + "\" сохранён в базе данных.");
            return ResponseEntity.ok("The document attachment is saved in the database");
        } catch (Exception ex) {
            log.error("Не удалось сохранить документ в базе данных. Message: {}. StackTrace: {}",
                    ex.getMessage(), ex.getStackTrace());
            throw ex;
        }

    }
}
