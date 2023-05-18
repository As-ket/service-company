package com.marketplace.companyservice.api.resource;

import com.marketplace.companyservice.api.dto.AuthSellerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * Интерфейс для общения с auth-service
 */
@Resource
@FeignClient(name = "auth-service", url = "http://localhost:8080")
public interface AuthServiceFeignClient {

    @PostMapping(value = "/api/auth/sign-in")
    ResponseEntity<String> signIn(@RequestBody AuthSellerDto seller);
}
