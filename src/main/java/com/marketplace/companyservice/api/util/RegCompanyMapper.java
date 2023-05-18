package com.marketplace.companyservice.api.util;


import com.marketplace.companyservice.api.dto.RegCompanyDto;
import com.marketplace.companyservice.api.entity.CompanyInformationEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Маппер для RegCompanyDto и CompanyInformationEntity
 */
@Service
@AllArgsConstructor
public class RegCompanyMapper {
    private final ModelMapper modelMapper;
    public RegCompanyDto convertEntityToDto (CompanyInformationEntity pictureEntity) {
        
        return modelMapper.map(pictureEntity, RegCompanyDto.class);
    }
    
    public CompanyInformationEntity convertDtoToEntity(RegCompanyDto pictureDTO) {
        
        return modelMapper.map(pictureDTO, CompanyInformationEntity.class);
    }
}