package com.marketplace.companyservice.api.repository;

import com.marketplace.companyservice.api.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, UUID> {
}
