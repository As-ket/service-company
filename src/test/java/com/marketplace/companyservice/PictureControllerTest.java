package com.marketplace.companyservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.companyservice.api.dto.PictureDTO;
import com.marketplace.companyservice.api.service.PictureService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест контроллера, доавляющего картинку-аватарку магазина
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PictureControllerTest {
    @Mock
    private PictureService pictureService;
    UUID myUUID = UUID.fromString("884a1aba-e14b-11ed-b5ea-0242ac120003");

    @Autowired
    private MockMvc mvc;
    @Test
    @Transactional
    public void savePictureBeCorrect() throws Exception {

        PictureDTO pictureDTO = new PictureDTO(myUUID, new Byte[30]);
        mvc.perform(post("/company/picture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(pictureDTO)))
                .andExpect(status().isOk());

    }

    public static String mapToJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
