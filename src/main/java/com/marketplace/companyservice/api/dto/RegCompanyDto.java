package com.marketplace.companyservice.api.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Дто для запроса регистрации
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Дто для регистрации", value = "RegCompanyDTO")
public class RegCompanyDto {
    @NonNull
    @Schema(description = "Название компании", example = "Рога и копыта")
    private String name;
    @NonNull
    @Schema(description = "Основная категория товаров", example = "Тепло и уют")
    private String mainCategory;
    @NonNull
    @Schema(description = "Полное название компании", example = "ООО \"Рога и копыта\"")
    private String legalName;
    @NonNull
    @Schema(description = "Тип компании", example = "ООО")
    private String type;
    @NonNull
    @Schema(description = "юр. ИНН 10 цифр", example = "1234567890")
    private String inn;

}
