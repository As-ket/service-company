package com.marketplace.companyservice.api.service;

import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import com.marketplace.companyservice.api.entity.DocumentAttachmentEntity;
import com.marketplace.companyservice.api.repository.DocumentAttachmentRepository;
import com.marketplace.companyservice.api.util.DocumentAttachmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Сервис для document_attachment */

@Service
@AllArgsConstructor
public class DocumentAttachmentServiceImpl implements DocumentAttachmentService{

    private final DocumentAttachmentRepository repository;
    private final DocumentAttachmentMapper mapper;

    @Override
    @Transactional
    public void saveDocAttach(DocumentAttachmentRequestDto requestDto) {
        DocumentAttachmentEntity entity = mapper.convertToEntity(requestDto);
        repository.save(entity);
    }
}
