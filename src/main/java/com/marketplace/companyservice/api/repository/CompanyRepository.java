package com.marketplace.companyservice.api.repository;

import com.marketplace.companyservice.api.entity.CompanyInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий для работы с CompanyInformationEntity
 */

@Repository
public interface CompanyRepository extends JpaRepository<CompanyInformationEntity, UUID> {

    Optional<CompanyInformationEntity> findByName(String companyName);

    Optional<CompanyInformationEntity> findByInn(String inn);

    void deleteByName(String companyName);

    Boolean existsByName(String companyName);

    Boolean existsByInn(String inn);
}
