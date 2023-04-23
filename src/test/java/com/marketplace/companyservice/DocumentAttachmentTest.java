package com.marketplace.companyservice;

import com.marketplace.companyservice.api.controller.DocumentAttachmentController;
import com.marketplace.companyservice.api.repository.DocumentAttachmentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Тест для document_attachment */

@SpringBootTest
class DocumentAttachmentTest {

    @Autowired
    private DocumentAttachmentController controller;

    @Autowired
    private DocumentAttachmentRepository repository;

    @Test
    void saveDocAttachTest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("docFile", "test.pdf", MediaType.MULTIPART_FORM_DATA_VALUE, "test data".getBytes());
        String strF = "PDF";
        String strT = "INN";

        ResponseEntity<String> response = controller.saveDocAttach(file, strF, strT);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("The document is saved in the database", response.getBody());
    }

    @AfterEach
    public void resetDb() {
        repository.delete(repository.findByName("test.pdf").get()); //TODO сделать клининг тестовых данных более безопасным
    }
}
