package com.marketplace.companyservice.api.dto;

import com.marketplace.companyservice.api.allEnums.FormatDocEnum;
import com.marketplace.companyservice.api.allEnums.TypeDocEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** Дто запрос для сущности document_attachment */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Дто запрос для сущности приложения к документу")
public class DocumentAttachmentRequestDto {

    @NonNull
    @Schema(description = "Название документа", example = "Название.pdf")
    private String name;
    @NonNull
    @Schema(description = "Тип документа", example = "Свидетельство ИНН")
    private TypeDocEnum type;
    @NonNull
    @Schema(description = "Формат документа", example = "pdf")
    private FormatDocEnum format;
    @NonNull
    @Schema(description = "Размер документа", example = "51019")
    private Integer size;
    @NonNull
    @Schema(description = "Докуммент в виде массива байт")
    private Byte[] value;
}
