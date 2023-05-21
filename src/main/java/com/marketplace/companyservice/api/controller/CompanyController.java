package com.marketplace.companyservice.api.controller;


import com.marketplace.companyservice.api.dto.RegCompanyDto;
import com.marketplace.companyservice.api.dto.UpdateCompanyDto;
import com.marketplace.companyservice.api.resource.CompanyResource;
import com.marketplace.companyservice.api.service.CompanyService;
import com.marketplace.companyservice.api.util.exceptions.CompanyNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class CompanyController implements CompanyResource {
    private final CompanyService companyService;

    @Override
    public ResponseEntity<String> regCompany(RegCompanyDto regDto) {
        companyService.register(regDto);
        return new ResponseEntity<>("Компания успешно зарегистрирована", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCompany(UpdateCompanyDto updateCompanyDto, BindingResult bindingResult, UUID id) {
        if(bindingResult.hasErrors()) {
            String errorMessages = bindingResult.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", ")); //для получения строки с сообщениями об ощибке из аннотаций
            log.warn("Данные компании не были обновлены \n" + errorMessages);
            return new ResponseEntity<>("Данные компании не были обновлены \n" + errorMessages, HttpStatus.BAD_REQUEST);
        }
        try {
            updateCompanyDto.setId(id);
            companyService.update(updateCompanyDto);
            log.info("Данные компании с id {} обновлены", id);
            return new ResponseEntity<>(String.format("Данные компании c id %s обновлены", id), HttpStatus.OK);
        } catch (CompanyNotFoundException e) {
            log.warn("Данные компании не были обновлены. Message: {}.  StackTrace: {}."
                    , e.getMessage(), e.getStackTrace());
            return new ResponseEntity<>("Данные компании не были обновлены \n" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}