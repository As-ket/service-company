package com.marketplace.companyservice.api.controller;

import com.marketplace.companyservice.api.allEnums.FormatDocEnum;
import com.marketplace.companyservice.api.allEnums.TypeDocEnum;
import com.marketplace.companyservice.api.constant.UrlConstants;
import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import com.marketplace.companyservice.api.service.DocumentAttachmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Arrays;

/** Контроллер для работы с document_attachment */

@Controller
@AllArgsConstructor
@RequestMapping(UrlConstants.MAIN_URL)
@Slf4j
public class DocumentAttachmentController {

    private final DocumentAttachmentService service;

    @PostMapping(value = "/document-attachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveDocAttach(@RequestParam("Name")MultipartFile docFile,
                                                @RequestParam("Format")String strF,
                                                @RequestParam("Type")String strT) {
        try(InputStream inputStream = docFile.getInputStream()) {
            if ((inputStream.available()< 33500000) &&
            (docFile.getOriginalFilename().endsWith("pdf") || docFile.getOriginalFilename().endsWith("jpeg") || docFile.getOriginalFilename().endsWith("png")))
            {
                DocumentAttachmentRequestDto dto = new DocumentAttachmentRequestDto();
                dto.setName(docFile.getOriginalFilename());
                dto.setSize(inputStream.available());
                dto.setValue(ArrayUtils.toObject(inputStream.readAllBytes()));
                dto.setFormat(FormatDocEnum.valueOf(strF));
                dto.setType(TypeDocEnum.valueOf(strT));
                service.saveDocAttach(dto);
            } else {
                log.warn("Не удалось сохранить файл в бд. Файл не отвечает необходимым требованиям");
                return new ResponseEntity<>("The file does not meet the required requirements", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            log.warn(ex.getMessage()+ "\n" + Arrays.toString(ex.getStackTrace()));
            throw new RuntimeException();
        }
        log.info("Файл \"" + docFile.getOriginalFilename() + "\" сохранён в базе данных.");
        return ResponseEntity.ok("The document is saved in the database");
    }
}
