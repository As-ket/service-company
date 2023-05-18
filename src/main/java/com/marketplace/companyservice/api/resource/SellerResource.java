package com.marketplace.companyservice.api.resource;

import com.marketplace.companyservice.api.dto.ExampleDto;
import com.marketplace.companyservice.api.dto.SellerDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.marketplace.companyservice.api.constant.UrlConstants.MAIN_URL;

/**
 * Ресурс для контролллера, добавляющего информацию о продавце
 */
@Tags(
        value = {
                @Tag(name = "Владелец магагзина", description = "Операции с продавцом")
        }
)
@RequestMapping(MAIN_URL)
public interface SellerResource {
    @PostMapping("/save-seller")
    @Operation(summary = "Сохранение данных  о продавце", tags = "Владелец магагзина")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные успешно сохранены",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Данные переданы неверно",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Данные переданы неверно",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Страница не найдена",
                    content = @Content) })
    ResponseEntity<String> saveSeller(@RequestBody SellerDto seller);
}