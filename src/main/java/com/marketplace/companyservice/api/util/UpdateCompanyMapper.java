package com.marketplace.companyservice.api.util;

import com.marketplace.companyservice.api.dto.UpdateCompanyDto;
import com.marketplace.companyservice.api.entity.CompanyInformationEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCompanyMapper {
    private final ModelMapper modelMapper;

    public UpdateCompanyDto convertEntityToDto (CompanyInformationEntity companyInformationEntity) {
        return modelMapper.map(companyInformationEntity, UpdateCompanyDto.class);
    }
    public CompanyInformationEntity convertDtoToEntity (UpdateCompanyDto updateCompanyDto) {
        return modelMapper.map(updateCompanyDto, CompanyInformationEntity.class);
    }
}
