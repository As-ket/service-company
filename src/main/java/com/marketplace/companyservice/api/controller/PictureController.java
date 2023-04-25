package com.marketplace.companyservice.api.controller;

import com.marketplace.companyservice.api.dto.PictureDTO;
import com.marketplace.companyservice.api.resource.PictureResource;
import com.marketplace.companyservice.api.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для добавления аватарки-картинки магазина
 */
@RestController
@Slf4j
public class PictureController implements PictureResource {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @Override
    public ResponseEntity<String> savePicture(PictureDTO picture) {
        try {
            pictureService.savePicture(picture);
            return ResponseEntity.ok("Картинка-аватарка добавлена");
        } catch (Exception e) {
            log.error("Картинка не может быть сохранена: ", e.getMessage());
            return new ResponseEntity<>("Картинка не может быть сохранена", HttpStatus.BAD_REQUEST);
        }
    }
}
