package com.marketplace.companyservice.api.service;

import com.marketplace.companyservice.api.dto.SellerDto;
import com.marketplace.companyservice.api.entity.SellerEntity;
import com.marketplace.companyservice.api.repository.SellerRepository;
import com.marketplace.companyservice.api.util.SellerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

/**
 * Сервис, реализующий добавление информации о продавце
 */

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerMapper sellerMapper;
    private final SellerRepository sellerRepository;

    @Transactional
    public void saveSeller(SellerDto seller) {
        SellerEntity sellerEntity =  sellerMapper.convertToEntity(seller);
        sellerEntity.setRegistrationDate(LocalDateTime.now());
        sellerRepository.save(sellerEntity);
    }
}
