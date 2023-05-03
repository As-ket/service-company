package com.marketplace.companyservice.api.resource;

import com.marketplace.companyservice.api.constant.UrlConstants;
import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Инкапсуляция аннотаций Swagger для контроллера
 */

@RequestMapping(UrlConstants.MAIN_URL)
@Tag(name = "Вложение для документа", description = "Операции с вложениями для документа")
public interface DocumentAttachmentResource {

    @PostMapping(value = "/document-attachment")
    @Operation(summary = "Добавление вложения для документа в бд", tags = "Вложение для документа")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Вложение сохранено",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "401", description = "Для действий на странице необходимо зарегистрироваться"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен"),
            @ApiResponse(responseCode = "404", description = "Страница не найдена")
    })
    ResponseEntity<String> saveDocAttach(@RequestBody DocumentAttachmentRequestDto requestDto);
}
