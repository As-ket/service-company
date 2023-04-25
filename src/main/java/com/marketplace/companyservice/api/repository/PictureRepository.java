package com.marketplace.companyservice.api.repository;

import com.marketplace.companyservice.api.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PictureRepository extends JpaRepository<PictureEntity, UUID> {
}
