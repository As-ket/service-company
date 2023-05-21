package com.marketplace.companyservice.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

/**
 * Дто для обновления данных компании
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Дто для обновления данных компании", value = "UpdateCompanyDto")
public class UpdateCompanyDto {

    @ApiModelProperty(hidden = true) //чтобы в свагере в example не появилось поле id
    private UUID id;

    @NonNull
    @NotNull(message = "name не должен быть пустым")
    @Schema(description = "Название компании", example = "Рога и копыта")
    private String name;

    @NonNull
    @NotNull(message = "mainCategory не должен быть пустым")
    @Schema(description = "Основная категория товаров", example = "Тепло и уют")
    private String mainCategory;

    @NonNull
    @NotNull(message = "legalName не должен быть пустым")
    @Schema(description = "Полное название компании", example = "ООО \"Рога и копыта\"")
    private String legalName;

    @NonNull
    @NotNull(message = "type не должен быть пустым")
    @Schema(description = "Тип компании", example = "ООО")
    private String type;

    @NonNull
    @NotNull(message = "inn не должен быть пустым")
    @Pattern(regexp = "\\d{10}", message = "ИНН должен состоять из 10 цифр")
    @Schema(description = "юр. ИНН 10 цифр", example = "1234567890")
    private String inn;

}
