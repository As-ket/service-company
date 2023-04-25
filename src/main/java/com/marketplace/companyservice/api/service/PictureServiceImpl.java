package com.marketplace.companyservice.api.service;

import com.marketplace.companyservice.api.dto.PictureDTO;
import com.marketplace.companyservice.api.entity.PictureEntity;
import com.marketplace.companyservice.api.repository.PictureRepository;
import com.marketplace.companyservice.api.util.PictureMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;

    /**
     * Сервис, реализующий добавление картинки-аватарки магазина
     * @param picture
     */

    @Override
    @Transactional
    public void savePicture(PictureDTO picture) {
        PictureEntity pictureEntity = pictureMapper.convertDtoToEntity(picture);
        pictureRepository.save(pictureEntity);
    }
}
