package com.milhas.api.repositories;

import com.milhas.api.models.StateModel;
import com.milhas.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<StateModel, Long> {
    StateModel findByInitials(String initials);
}
