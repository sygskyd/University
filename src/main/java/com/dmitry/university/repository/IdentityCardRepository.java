package com.dmitry.university.repository;

import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityCardRepository extends JpaRepository<BaseIdentityEntity, Integer> {

}
