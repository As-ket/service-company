package com.marketplace.companyservice;

import com.marketplace.companyservice.api.controller.DocumentAttachmentController;
import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import com.marketplace.companyservice.api.service.DocumentAttachmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Тест для document_attachment контроллера*/

@SpringBootTest
class DocumentAttachmentTest {

    @Mock
    private DocumentAttachmentService service;

    @Test
    public void saveDocAttachTest() {
        DocumentAttachmentRequestDto docFile = new DocumentAttachmentRequestDto();
        docFile.setName("test.pdf");
        docFile.setValue(new Byte[100]);
        DocumentAttachmentController controller = new DocumentAttachmentController(service);
        ResponseEntity<String> response = controller.saveDocAttach(docFile);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("The document is saved in the database", response.getBody());
    }

    @Test
    public void saveDocAttachInvalidFileTest() {
        DocumentAttachmentRequestDto docFile = new DocumentAttachmentRequestDto();
        docFile.setName("test.docx");
        docFile.setValue(new Byte[40000000]);
        DocumentAttachmentController controller = new DocumentAttachmentController(service);
        ResponseEntity<String> response = controller.saveDocAttach(docFile);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("The file does not meet the required requirements", response.getBody());
    }
}
