package com.marketplace.companyservice.api.controller;

import com.marketplace.companyservice.api.dto.PictureDto;
import com.marketplace.companyservice.api.resource.PictureResource;
import com.marketplace.companyservice.api.service.PictureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для добавления аватарки-картинки магазина
 */
@RestController
@Slf4j
@AllArgsConstructor
public class PictureController implements PictureResource {

    private final PictureService pictureService;

    @Override
    public ResponseEntity<String> savePicture(PictureDto picture) {
        try {
            pictureService.savePicture(picture);
            return ResponseEntity.ok("Картинка-аватарка добавлена");
        } catch (Exception e) {
            log.error("Картинка не может быть сохранена. Message: {}.  StackTrace: {}."
                    , e.getMessage(), e.getStackTrace());
            return new ResponseEntity<>("Картинка не может быть сохранена", HttpStatus.BAD_REQUEST);
        }
    }
}
