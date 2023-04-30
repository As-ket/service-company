package com.marketplace.companyservice.api.service;

import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import com.marketplace.companyservice.api.entity.DocumentAttachmentEntity;
import com.marketplace.companyservice.api.repository.DocumentAttachmentRepository;
import com.marketplace.companyservice.api.util.DocumentAttachmentMapper;
import com.marketplace.companyservice.api.util.exceptions.InvalidSizeDocAttachException;
import com.marketplace.companyservice.api.util.exceptions.InvalidTypeDocAttachException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для document_attachment
 */

@Service
@AllArgsConstructor
public class DocumentAttachmentService {

    private final DocumentAttachmentRepository repository;
    private final DocumentAttachmentMapper mapper;

    @Transactional
    public void saveDocAttach(DocumentAttachmentRequestDto requestDto) throws RuntimeException {
        if (validationDocAttachSize(requestDto)) {
            if (validationDocAttachType(requestDto)) {
                DocumentAttachmentEntity entity = mapper.convertToEntity(requestDto);
                entity.setSize(requestDto.getValue().length);
                repository.save(entity);
            } else {
                throw new InvalidTypeDocAttachException("Недопустимый тип файла.");
            }
        } else {
            throw new InvalidSizeDocAttachException("Недопустимый размер файла.");
        }
    }

    private boolean validationDocAttachSize(DocumentAttachmentRequestDto dto) {
        return dto.getValue().length < 33554432;
    }

    private boolean validationDocAttachType(DocumentAttachmentRequestDto dto) {
        return dto.getName().endsWith("pdf") || dto.getName().endsWith("jpeg") || dto.getName().endsWith("png");
    }
}
