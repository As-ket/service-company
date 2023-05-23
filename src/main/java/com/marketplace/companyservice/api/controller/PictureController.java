package com.marketplace.companyservice.api.controller;

import com.marketplace.companyservice.api.dto.PictureDto;
import com.marketplace.companyservice.api.resource.PictureResource;
import com.marketplace.companyservice.api.service.PictureService;
import com.marketplace.companyservice.api.util.exceptions.CompanyNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * Контроллер, реализующий действия с картинкой-аватаром магазина
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

    @Override
    public ResponseEntity<String> updatePictureById(PictureDto picture, UUID id) {
        try {
            pictureService.updatePicture(picture);
            log.info("Картинка компании с id %s обновлена", id);
            return new ResponseEntity<>(String.format("Картинка компании с id %s обновлена", id), HttpStatus.OK);
        } catch (CompanyNotFoundException e) {
            log.warn("Картинка компании не была обновлены. Message: {}. StackTrace: {}", e.getMessage(), e.getStackTrace());
            return new ResponseEntity<>("Картинка компании не была обновлены. \n" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
