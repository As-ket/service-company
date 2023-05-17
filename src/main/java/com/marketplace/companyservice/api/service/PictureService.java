package com.marketplace.companyservice.api.service;

import com.marketplace.companyservice.api.dto.PictureDto;
import com.marketplace.companyservice.api.entity.PictureEntity;
import com.marketplace.companyservice.api.repository.CompanyRepository;
import com.marketplace.companyservice.api.repository.PictureRepository;
import com.marketplace.companyservice.api.util.PictureMapper;
import com.marketplace.companyservice.api.util.exceptions.CompanyNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис, реализующий добавление картинки-аватарки магазина
 */

@Service
@AllArgsConstructor
public class PictureService {

    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;
    private final CompanyRepository companyRepository;

    @Transactional
    public void savePicture(PictureDto picture) {
        PictureEntity pictureEntity = pictureMapper.convertDtoToEntity(picture);
        if (! companyRepository.findById(picture.getId()).isEmpty()) {
            pictureRepository.save(pictureEntity);
        } else {
            throw new CompanyNotFoundException("Компания с ID "+ picture.getId() + " не найдена.");
        }

    }

}
