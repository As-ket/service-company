package com.marketplace.companyservice.api.dto;

import com.marketplace.companyservice.api.allEnums.FormatDocEnum;
import com.marketplace.companyservice.api.allEnums.TypeDocEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** Дто запрос для сущности document_attachment */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Дто запрос для сущности приложения к документу", value = "DocumentDTO")
public class DocumentAttachmentRequestDto {

    @NonNull
    @Schema(description = "Название документа", example = "Название.pdf")
    private String name;
    @NonNull
    @Schema(type = "enum", description = "Тип документа", example = "Свидетельство ИНН")
    private TypeDocEnum type;
    @NonNull
    @Schema(type = "enum", description = "Формат документа", example = "pdf")
    private FormatDocEnum format;
    @NonNull
    @Schema(description = "Докуммент")
    private Byte[] value;
    @Schema(description = "Размер документа")
    private  Integer size;
}
