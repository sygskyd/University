package com.dmitry.university.repository;

import com.dmitry.university.model.IdentityCard.MilitaryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilitaryCardRepository extends JpaRepository<MilitaryCard, Integer> {

}
