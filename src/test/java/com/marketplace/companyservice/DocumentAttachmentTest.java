package com.marketplace.companyservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.companyservice.api.allEnums.FormatDocEnum;
import com.marketplace.companyservice.api.allEnums.TypeDocEnum;
import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Тест для document attachment контроллера */

@SpringBootTest
@AutoConfigureMockMvc
class DocumentAttachmentTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void saveDocAttachTest() throws Exception {
        DocumentAttachmentRequestDto docFile = new DocumentAttachmentRequestDto("test.pdf", TypeDocEnum.INN,
                FormatDocEnum.PDF, new Byte[100]);
        mvc.perform(post("/company/document-attachment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(docFile)))
                .andExpect(status().isOk());
    }

    @Test
    public void saveDocAttachInvalidTypeTest() throws Exception {
        DocumentAttachmentRequestDto docFile = new DocumentAttachmentRequestDto("test.docx", TypeDocEnum.INN,
                FormatDocEnum.PDF, new Byte[100]);
        mvc.perform(post("/company/document-attachment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(docFile)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Недопустимый тип файла."));
    }

    @Test
    public void saveDocAttachInvalidSizeTest() throws Exception {
        DocumentAttachmentRequestDto docFile = new DocumentAttachmentRequestDto("test.pdf", TypeDocEnum.INN,
                FormatDocEnum.PDF, new Byte[40000000]);
        mvc.perform(post("/company/document-attachment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(docFile)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Недопустимый размер файла."));
    }

    public static String mapToJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
