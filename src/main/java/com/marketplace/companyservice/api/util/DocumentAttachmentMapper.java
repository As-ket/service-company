package com.marketplace.companyservice.api.util;

import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import com.marketplace.companyservice.api.entity.DocumentAttachmentEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Реализация маппинга для DTO и сущности document_attachment
 */

@Service
@AllArgsConstructor
public class DocumentAttachmentMapper {

    private final ModelMapper modelMapper;

    public DocumentAttachmentRequestDto convertToDto (DocumentAttachmentEntity entity) {
        return modelMapper.map(entity, DocumentAttachmentRequestDto.class);
    }

    public DocumentAttachmentEntity convertToEntity (DocumentAttachmentRequestDto requestDto) {
        return  modelMapper.map(requestDto, DocumentAttachmentEntity.class);
    }
}
