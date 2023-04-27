package com.marketplace.companyservice.api.repository;

import com.marketplace.companyservice.api.entity.CompanyInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyInformationEntity, UUID> {

}
