package com.dmitry.university.service;

import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import com.dmitry.university.repository.IdentityCardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IdentityCardServiceImpl implements IdentityCardService {


    private IdentityCardRepository identityCardRepository;

    public IdentityCardServiceImpl(IdentityCardRepository identityCardRepository) {
        this.identityCardRepository = identityCardRepository;
    }

    @Override
    public Page<BaseIdentityEntity> findAll(int page, int size) {
        return identityCardRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public BaseIdentityEntity findById(int theId) {
        return identityCardRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + theId));
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
