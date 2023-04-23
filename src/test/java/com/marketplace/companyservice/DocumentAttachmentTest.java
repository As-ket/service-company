package com.marketplace.companyservice;

import com.marketplace.companyservice.api.allEnums.FormatDocEnum;
import com.marketplace.companyservice.api.allEnums.TypeDocEnum;
import com.marketplace.companyservice.api.entity.DocumentAttachmentEntity;
import com.marketplace.companyservice.api.repository.DocumentAttachmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/** Тест для document_attachment */

@SpringBootTest
class DocumentAttachmentTest {

    @Autowired
    private DocumentAttachmentRepository repository;

    @Test
    @Transactional
    public void saveDoc(){
        Byte[] bytes = {0x5,0x5,0x5,0x5,0x5,0x5,0x5,0x5,0x5,0x5,0x5,0x5,0x5};
        DocumentAttachmentEntity entity = new DocumentAttachmentEntity(null,  bytes, "DocTest.pdf",
                10000, FormatDocEnum.PDF, TypeDocEnum.INN);
        repository.save(entity);
        System.out.println(repository.findByDocumentName("DocTest.pdf"));
    }
}
