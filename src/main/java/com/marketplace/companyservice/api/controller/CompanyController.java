package com.marketplace.companyservice.api.controller;


import com.marketplace.companyservice.api.dto.RegCompanyDto;
import com.marketplace.companyservice.api.resource.CompanyResource;
import com.marketplace.companyservice.api.service.CompanyService;
import com.marketplace.companyservice.api.util.exceptions.CompanyAlreadyExistException;
import com.marketplace.companyservice.api.util.exceptions.InnNotValidException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class CompanyController implements CompanyResource {
    private final CompanyService companyService;
    
    @Override
    public ResponseEntity<String> regCompany(RegCompanyDto regDto) {
        try {
            companyService.register(regDto);
            return new ResponseEntity<>("Компания успешно зарегистрирована", HttpStatus.OK);
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
