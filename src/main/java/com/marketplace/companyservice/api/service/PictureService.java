package com.marketplace.companyservice.api.service;

import com.marketplace.companyservice.api.dto.PictureDTO;

/**
 * Интерфейс для сервиса по добавлению картикнки-аватарки
 */
public interface PictureService {

    void savePicture (PictureDTO picture);
}
