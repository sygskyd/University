package com.dmitry.university.service;

import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import org.springframework.data.domain.Page;

public interface IdentityCardService {
    Page<BaseIdentityEntity> findAll(int page, int size);

    BaseIdentityEntity findById(int theId);

    void save(BaseIdentityEntity identityCard);

    void deleteById(int theId);
}
