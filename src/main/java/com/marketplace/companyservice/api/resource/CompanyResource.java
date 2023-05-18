package com.marketplace.companyservice.api.resource;


import com.marketplace.companyservice.api.constant.UrlConstants;
import com.marketplace.companyservice.api.dto.RegCompanyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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


/**
 * Описание методов CompanyController
 */

@Tags(
        value = {
                @Tag(name = "Компания", description = "Управление компанией")
        }
)
@RequestMapping(UrlConstants.MAIN_URL)
public interface CompanyResource {

    @PostMapping("")
    @Operation(summary = "Регистрация компании", tags = {"Компания"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Компания зарегистрирована",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Неверный ИНН/Имя или ИНН уже заняты",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})
    })
    ResponseEntity<String> regCompany(@Parameter(description = "Регистрационные данные компании") @RequestBody RegCompanyDto regDto);
}
