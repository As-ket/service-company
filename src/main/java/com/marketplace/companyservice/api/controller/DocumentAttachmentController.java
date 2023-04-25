package com.marketplace.companyservice.api.controller;

import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import com.marketplace.companyservice.api.resource.DocumentAttachmentResource;
import com.marketplace.companyservice.api.service.DocumentAttachmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/** Контроллер для работы с document_attachment */

@RestController
@AllArgsConstructor
@Slf4j
public class DocumentAttachmentController implements DocumentAttachmentResource {

    private final DocumentAttachmentService service;

    @Override
    public ResponseEntity<String> saveDocAttach(DocumentAttachmentRequestDto docFile) {
            if ((docFile.getValue().length< 33500000) &&
            (docFile.getName().endsWith("pdf") || docFile.getName().endsWith("jpeg") || docFile.getName().endsWith("png")))
            {
                docFile.setSize(docFile.getValue().length);
                service.saveDocAttach(docFile);
            } else { // TODO создать исключение на непройденную валидацию
                log.error("Не удалось сохранить файл в бд. Файл не отвечает необходимым требованиям");
                return new ResponseEntity<>("The file does not meet the required requirements", HttpStatus.BAD_REQUEST);
            }
        log.info("Файл \"" + docFile.getName() + "\" сохранён в базе данных.");
        return ResponseEntity.ok("The document is saved in the database");
    }
}
