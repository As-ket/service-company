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
public class PictureDTO {

    @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "Уникальный идентификатор картинки")
    private UUID id;

    @Schema(example = "[10, 22, 12, 121, 23, 23...]", description = "Картинка-аватарка (массив байт))")
    private Byte[] picture;

}
