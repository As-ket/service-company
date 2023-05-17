package com.marketplace.companyservice.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO объект, использующийся для добавления картинки-аватара магазина.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Дто для добавления картинки-аватара магазина")
public class PictureDto {

    @Schema(description = "Уникальный идентификатор компании")
    private UUID id;

    @Schema(description = "Картинка-аватарка (массив байт))")
    private Byte[] picture;

}
