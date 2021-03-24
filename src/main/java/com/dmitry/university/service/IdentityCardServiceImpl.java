package com.dmitry.university.service;

import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
//import com.dmitry.university.model.IdentityCard.MilitaryCard;
import com.dmitry.university.repository.IdentityCardRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IdentityCardServiceImpl implements IdentityCardService {

    private IdentityCardRepository identityCardRepository;

    public IdentityCardServiceImpl(IdentityCardRepository identityCardRepository) {
        this.identityCardRepository = identityCardRepository;
    }


    @Override
    public List<BaseIdentityEntity> findAll() {
        return identityCardRepository.findAll();
    }

    @Override
    public BaseIdentityEntity findById(int theId) {
        return identityCardRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + theId));
    }

    @Override
    public void save(BaseIdentityEntity identityCard) {
        identityCardRepository.save(identityCard);
    }

    @Override
    public void deleteById(int theId) {
        identityCardRepository.deleteById(theId);
    }
}
