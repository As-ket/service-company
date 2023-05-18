package com.marketplace.companyservice;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.marketplace.companyservice.api.dto.SellerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест контроллера на проверку  в auth на регистрацию и добавление в базу company информации о продавце
 */

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Transactional
    @Test
    public void savePictureBeCorrect() throws Exception {

        SellerDto sellerDTO = new SellerDto("Petr", "Petrov","mail@mail.ru", "123");
        mockMvc.perform(post("/company/save-seller")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(sellerDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("Информация о продавце успешно добавлена в базу!"));
    }

    public static String mapToJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
