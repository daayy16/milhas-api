package com.milhas.api.repositories;

import com.milhas.api.models.PromotionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionModel, Long> {
}
