package com.marketplace.companyservice.api.resource;

import com.marketplace.companyservice.api.constant.UrlConstants;
import com.marketplace.companyservice.api.dto.PictureDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

/**
 * Ресурс для контролллера, реализующий действия с картинкой-аватаром магазина
 *
 */

@RequestMapping(UrlConstants.MAIN_URL)
@Tag(name = "Картинка-аватарка", description = "Добавление/изменение картинки-аватарки магазина")
public interface PictureResource {
    @PostMapping(value = "/picture")
    @Operation(summary = "Добавление картинки", tags = "Картинка-аватарка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Картинка добавлена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "401", description = "Для добавления картинки необходимо зарегистрироваться",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = "Страница не найдена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})
    })
    ResponseEntity<String> savePicture(@RequestBody PictureDto picture);

    @PutMapping("/picture/{id}")
    @Operation(summary = "Изменить картинку компании", tags = "Картинка-аватарка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Картинка обновлена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Не удалось обновить картинку",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})
    })
    ResponseEntity<String> updatePictureById(@RequestBody @Valid PictureDto pictureDto, @PathVariable UUID id);
}

