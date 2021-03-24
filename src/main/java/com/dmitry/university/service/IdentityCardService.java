package com.dmitry.university.service;

import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
//import com.dmitry.university.model.IdentityCard.MilitaryCard;

import java.util.List;

public interface IdentityCardService {
    List<BaseIdentityEntity> findAll();

    BaseIdentityEntity findById(int theId);

    void save(BaseIdentityEntity identityCard);

    void deleteById(int theId);
}
