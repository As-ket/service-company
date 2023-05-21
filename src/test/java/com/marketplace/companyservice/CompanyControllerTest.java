package com.marketplace.companyservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.companyservice.api.dto.RegCompanyDto;
import com.marketplace.companyservice.api.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {
    @MockBean
    private CompanyService companyService;
    
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void whenNotValidInn() throws Exception {
        
        RegCompanyDto regDto = getRegCompanyDto();
        when(companyService.isValidInn(regDto)).thenReturn(false);
        
        mvc.perform(post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(regDto)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Неверный ИНН"));
    }
    
    @Test
    public void whenInnOccupied() throws Exception {

        RegCompanyDto regDto = getRegCompanyDto();
        when(companyService.isValidInn(regDto)).thenReturn(true);
        when(companyService.existsByInn(regDto)).thenReturn(true);
        
        mvc.perform(post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(regDto)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Компания с таким именем/ИНН уже зарегистрирована"));
    }
    
    @Test
    public void whenNameOccupied() throws Exception {
    
        RegCompanyDto regDto = getRegCompanyDto();
        when(companyService.isValidInn(regDto)).thenReturn(true);
        when(companyService.existsByCompanyName(regDto)).thenReturn(true);
        
        mvc.perform(post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(regDto)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Компания с таким именем/ИНН уже зарегистрирована"));
    }
    
    @Test
    public void whenCompanyRegistered() throws Exception {
        
        RegCompanyDto regDto = getRegCompanyDto();
        when(companyService.isValidInn(regDto)).thenReturn(true);
        when(companyService.existsByCompanyName(regDto)).thenReturn(false);
        when(companyService.existsByCompanyName(regDto)).thenReturn(false);
        
        mvc.perform(post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(regDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Компания успешно зарегистрирована"));
    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static RegCompanyDto getRegCompanyDto(){
        RegCompanyDto regDto = new RegCompanyDto();
        regDto.setName("Рога и копыта");
        regDto.setMainCategory("Товары для дома");
        regDto.setLegalName("");
        regDto.setType("ООО");
        regDto.setInn("1234567892");
        return regDto;
    }
}
