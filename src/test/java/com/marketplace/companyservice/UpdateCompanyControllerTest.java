package com.marketplace.companyservice;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.companyservice.api.dto.UpdateCompanyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест контроллера, который обновляет данные о компании
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UpdateCompanyControllerTest {

    @Autowired
    private MockMvc mvc;

    private static UpdateCompanyDto getUpdateCompanyDto() {
        UpdateCompanyDto companyDto = new UpdateCompanyDto();
        companyDto.setInn("1234567890");
        companyDto.setName("Петя");
        companyDto.setLegalName("ООО Дум");
        companyDto.setType("ООО");
        companyDto.setMainCategory("Канцтовары");
        return companyDto;
    }

    private static UpdateCompanyDto getUpdateCompanyDtoWithInvalidInn() {
        UpdateCompanyDto companyDto = new UpdateCompanyDto();
        companyDto.setInn("11232334567890");
        companyDto.setName("Петя");
        companyDto.setLegalName("ООО Дум");
        companyDto.setType("ООО");
        companyDto.setMainCategory("Канцтовары");
        return companyDto;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void update_company_with_valid_data() throws Exception {
        UpdateCompanyDto updateCompanyDto = getUpdateCompanyDto();
        String companyId = "edd73344-5456-4a01-b1e0-cbca77473f1d"; //id есть в бд
        mvc.perform(put("/company/" + companyId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updateCompanyDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Данные компании c id %s обновлены", companyId)));
    }

    @Test //должен возвращаться 400 код ошибки, но возварщается 200, в свагере и постмане все работает нормально
    public void update_company_with_invalid_id() throws Exception {
        UpdateCompanyDto updateCompanyDto = getUpdateCompanyDto();
        String companyId = "edd73344-5456-4a01-b1e0-cbca77473f11"; //id нет в бд
        mvc.perform(put("/company/" + companyId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updateCompanyDto)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Данные компании не были обновлены" + String.format("Компания с id %s не существует", companyId)));
    }

    @Test
    public void update_company_with_invalid_inn() throws Exception {
        UpdateCompanyDto updateCompanyDto = getUpdateCompanyDtoWithInvalidInn();
        String companyId = "edd73344-5456-4a01-b1e0-cbca77473f1d"; //id есть в бд
        mvc.perform(put("/company/" + companyId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updateCompanyDto)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Данные компании не были обновлены \nИНН должен состоять из 10 цифр"));
    }

    @Test
    public void update_company_with_empty_data() throws Exception {
        String companyId = "edd73344-5456-4a01-b1e0-cbca77473f1d"; //id есть в бд
        mvc.perform(put("/company/" + companyId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
        //не проверяю сообщение с ошибкой, так как оно всегда разное
    }


}
