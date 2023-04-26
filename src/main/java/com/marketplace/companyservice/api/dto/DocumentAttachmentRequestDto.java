package com.marketplace.companyservice.api.dto;

import com.marketplace.companyservice.api.allEnums.FormatDocEnum;
import com.marketplace.companyservice.api.allEnums.TypeDocEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** Дто вложение для документа */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Дто вложение для документа", value = "DocumentAttachmentDTO")
public class DocumentAttachmentRequestDto {

    @NonNull
    @Schema(description = "Название файла", example = "Название.pdf")
    private String name;
    @NonNull
    @Schema(description = "Тип файла", example = "Свидетельство ИНН")
    private TypeDocEnum type;
    @NonNull
    @Schema(description = "Формат файла", example = "pdf")
    private FormatDocEnum format;
    @NonNull
    @Schema(description = "Файл")
    private Byte[] value;

}
