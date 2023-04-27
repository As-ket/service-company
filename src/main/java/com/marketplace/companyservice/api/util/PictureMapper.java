package com.marketplace.companyservice.api.util;

import com.marketplace.companyservice.api.dto.PictureDto;
import com.marketplace.companyservice.api.entity.PictureEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Реализация маппинга для PictureDTO и PictureEntity
 * при добавлении картинки-аватарки
 */
@Service
@AllArgsConstructor
public class PictureMapper {

    private final ModelMapper modelMapper;
    public PictureDto convertEntityToDto (PictureEntity pictureEntity) {

        return modelMapper.map(pictureEntity, PictureDto.class);
    }

    public PictureEntity convertDtoToEntity(PictureDto pictureDTO) {

        return modelMapper.map(pictureDTO, PictureEntity.class);
    }
}
