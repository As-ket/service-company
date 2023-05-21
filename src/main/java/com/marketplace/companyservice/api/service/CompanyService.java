package com.marketplace.companyservice.api.service;


import com.marketplace.companyservice.api.dto.RegCompanyDto;
import com.marketplace.companyservice.api.dto.UpdateCompanyDto;
import com.marketplace.companyservice.api.entity.CompanyInformationEntity;
import com.marketplace.companyservice.api.repository.CompanyRepository;
import com.marketplace.companyservice.api.util.RegCompanyMapper;
import com.marketplace.companyservice.api.util.UpdateCompanyMapper;
import com.marketplace.companyservice.api.util.exceptions.CompanyAlreadyExistException;
import com.marketplace.companyservice.api.util.exceptions.CompanyNotFoundException;
import com.marketplace.companyservice.api.util.exceptions.InnNotValidException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для компании
 */
@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final RegCompanyMapper regCompanyMapper;
    private final UpdateCompanyMapper updateCompanyMapper;

    @Transactional
    public void register(RegCompanyDto regDto) throws RuntimeException {
        if (isValidInn(regDto)) {
            if (!(existsByInn(regDto) || existsByCompanyName(regDto))) {
                CompanyInformationEntity company = regCompanyMapper.convertDtoToEntity(regDto);
                company.setIsActive(true);
                companyRepository.save(company);
            } else {
                throw new CompanyAlreadyExistException("Компания с таким именем/ИНН уже зарегистрирована");
            }
        } else {
            throw new InnNotValidException("Неверный ИНН");
        }

    }

    @Transactional
    public void update(UpdateCompanyDto updateDto) {
        if(companyRepository.findById(updateDto.getId()).isEmpty()) {
            throw new CompanyNotFoundException(String.format("Компания с id %s не существует", updateDto.getId()));
        }
        CompanyInformationEntity companyInformation = updateCompanyMapper.convertDtoToEntity(updateDto);
        companyInformation.setIsActive(true);
        companyRepository.save(companyInformation);
    }

    public boolean existsByCompanyName(RegCompanyDto regDto) {
        return companyRepository.existsByName(regDto.getName());
    }

    public boolean existsByInn(RegCompanyDto regDto) {
        return companyRepository.existsByInn(regDto.getInn());
    }

    public boolean isValidInn(RegCompanyDto regDto) {
        return regDto.getInn().length() == 10;
    }

}
