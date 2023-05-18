package com.marketplace.companyservice.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


/**
 * DTO объект, использующийся для добавления информации о продавце
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SellerDto {

    @Schema(example = "Иван", description = "Имя владельца магазина")
    @NotNull(message = "account.dto.validate.accountNumber.isEmpty")
    private String name;
    @Schema(example = "Иванов", description = "Фамилия владельца магазина")
    @NotNull(message = "account.dto.validate.accountNumber.isEmpty")
    private String surname;
    @Schema(example = "ivan@mail.ru", description = "Электронная почта владельца магазина")
    @NotNull(message = "account.dto.validate.accountNumber.isEmpty")
    private String email;
    @Schema(example = "Пароль", description = "Пароль владельца магазина")
    @NotNull(message = "account.dto.validate.accountNumber.isEmpty")
    private String password;
}
