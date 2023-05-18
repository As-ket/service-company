package com.marketplace.companyservice.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * DTO объект, использующийся для добавления продавца в базу данных сервиса Auth
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthSellerDto {

    @Schema(example = "ivan@mail.ru", description = "Электронная почта владельца магазина")
    @NotNull(message = "account.dto.validate.accountNumber.isEmpty")
    private String username;

    @Schema(example = "ivan@mail.ru", description = "Электронная почта владельца магазина")
    @NotNull(message = "account.dto.validate.accountNumber.isEmpty")
    private String password;

    @Schema(example = "ivan@mail.ru", description = "Роль владельца магазина")
    @NotNull(message = "account.dto.validate.accountNumber.isEmpty")
    private String role;
}
