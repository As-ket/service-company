package com.marketplace.companyservice.api.resource;

import com.marketplace.companyservice.api.constant.UrlConstants;
import com.marketplace.companyservice.api.dto.PictureDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ресурс для контролллера, добавляющего карнтинку-аватарку магазина
 */

@RequestMapping(UrlConstants.MAIN_URL)
@Tag(name = "Картинка-аватарка", description = "Добавление картинки-аватарки магазина")
public interface PictureResource {
    @PostMapping(value = "/picture")
    @Operation(summary = "Добавление картинки", tags = "Картинка-аватарка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Картинка добавлена"),
            @ApiResponse(responseCode = "401", description = "Для добавления картинки необходимо зарегистрироваться"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен"),
            @ApiResponse(responseCode = "404", description = "Страница не найдена")
    })
    ResponseEntity<String> savePicture(@RequestBody PictureDTO picture);
}
