package com.milhas.api.repositories;

import com.milhas.api.models.CompanyModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
    Optional<CompanyModel> findByName(String name);
}
