package com.marketplace.companyservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.companyservice.api.dto.PictureDto;
import com.marketplace.companyservice.api.entity.CompanyInformationEntity;
import com.marketplace.companyservice.api.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест контроллера, реализующий действия с картинкой-аватаром магазина
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PictureControllerTest {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    @Transactional
    public void savePictureBeNoCorrect() throws Exception {
        UUID myUUID = UUID.fromString("47850b37-85ad-43d0-9fec-c910229c0cf9");
        PictureDto pictureDTO = new PictureDto(myUUID, new Byte[]{10, 12, 32, 15});
        mvc.perform(post("/company/picture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(pictureDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void savePictureBeCorrect() throws Exception {
        CompanyInformationEntity companyInformation =
                new CompanyInformationEntity(null, "name", 10.1, "category",
                        null, "dfdf", "dfdf", "12121", true, null);
        companyRepository.save(companyInformation);
        PictureDto pictureDTO = new PictureDto(companyInformation.getId(), new Byte[]{10, 12, 32, 15});
        mvc.perform(post("/company/picture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(pictureDTO)))
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    public void updatePictureBeNoCorrect() throws Exception {
        UUID myUUID = UUID.fromString("47850b37-85ad-43d0-9fec-c910229c0cf9");
        PictureDto pictureDTO = new PictureDto(myUUID, new Byte[]{10, 12, 32, 15});
        mvc.perform(put("/company/picture/47850b37-85ad-43d0-9fec-c910229c0cf9")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(pictureDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void updatePictureBeCorrect() throws Exception {
        CompanyInformationEntity companyInformation =
                new CompanyInformationEntity(null, "name", 10.1, "category",
                        null, "dfdf", "dfdf", "12121", true, null);
        companyRepository.save(companyInformation);
        PictureDto pictureDTO = new PictureDto(companyInformation.getId(), new Byte[]{10, 12, 32, 15});
        mvc.perform(put("/company/picture/" + companyInformation.getId())
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
