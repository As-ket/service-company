package com.marketplace.companyservice.api.repository;

import com.marketplace.companyservice.api.entity.CompanyInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с CompanyInformationEntity
 */

@Repository
public interface CompanyRepository extends JpaRepository<CompanyInformationEntity, UUID> {

    Boolean existsByName(String companyName);

    Boolean existsByInn(String inn);
}
