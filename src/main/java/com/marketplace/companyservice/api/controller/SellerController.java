package com.marketplace.companyservice.api.controller;

import com.marketplace.companyservice.api.dto.AuthSellerDto;
import com.marketplace.companyservice.api.dto.SellerDto;
import com.marketplace.companyservice.api.resource.AuthServiceFeignClient;
import com.marketplace.companyservice.api.resource.SellerResource;
import com.marketplace.companyservice.api.service.SellerService;
import com.marketplace.companyservice.api.util.exception.SellerAuthException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для добавления информации оп родавце в базы данных,
 * а также проверка в auth-service уже зарегистрированного продавца
 */

@Slf4j
@RestController
@AllArgsConstructor
public class SellerController implements SellerResource {
    private final SellerService sellerService;
    @Autowired
    private final AuthServiceFeignClient authServiceFeignClient;

    @Override
    public ResponseEntity<String> saveSeller(SellerDto seller) {
        try {
            AuthSellerDto authSellerDto = new AuthSellerDto();

            authSellerDto.setUsername(seller.getEmail());
            authSellerDto.setPassword(seller.getPassword());
            authSellerDto.setRole("SELLER");
            authServiceFeignClient.signIn(authSellerDto);

            sellerService.saveSeller(seller);
            return ResponseEntity.ok("Информация о продавце успешно добавлена в базу!");

        } catch (SellerAuthException e) {
            log.error("Информация о продавце не может быть сохранена: {}, статус: {}", e.getStackTrace(), e.status());
            return new ResponseEntity<>("Информация о продавце не может быть сохранена", HttpStatus.BAD_REQUEST);
        }
    }
}
