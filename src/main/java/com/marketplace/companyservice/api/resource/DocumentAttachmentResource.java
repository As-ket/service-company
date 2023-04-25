package com.marketplace.companyservice.api.resource;

import com.marketplace.companyservice.api.constant.UrlConstants;
import com.marketplace.companyservice.api.dto.DocumentAttachmentRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/** Инкапсуляция аннотаций Swagger для контроллера */

@RequestMapping(UrlConstants.MAIN_URL)
@Tag(name = "Документ", description = "Операции с документом")
public interface DocumentAttachmentResource {

    @PostMapping(value = "/document-attachment")
    @Operation(summary = "Добавление документа в бд", tags = "Документ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Документ сохранён"),
            @ApiResponse(responseCode = "401", description = "Для действий на странице необходимо зарегистрироваться"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен"),
            @ApiResponse(responseCode = "404", description = "Страница не найдена")
    })
    ResponseEntity<String> saveDocAttach(@RequestBody DocumentAttachmentRequestDto requestDto);
}
