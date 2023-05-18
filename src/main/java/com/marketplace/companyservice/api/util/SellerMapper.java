package com.marketplace.companyservice.api.util;

import com.marketplace.companyservice.api.dto.SellerDto;
import com.marketplace.companyservice.api.entity.SellerEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Реализация маппинга для DTO и сущности Seller
 * */

@Service
@AllArgsConstructor
public class SellerMapper {

    private final ModelMapper modelMapper;

    public SellerDto convertToDto (SellerEntity entity) {
        return modelMapper.map(entity, SellerDto.class);
    }

    public SellerEntity convertToEntity (SellerDto requestDto) {
        return  modelMapper.map(requestDto, SellerEntity.class);
    }
}