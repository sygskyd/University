package com.dmitry.university.service;

import com.dmitry.university.model.IdentityCard.MilitaryCard;
import com.dmitry.university.repository.MilitaryCardRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MilitaryCardServiceImpl implements MilitaryCardService {

    private MilitaryCardRepository militaryCardRepository;

    public MilitaryCardServiceImpl(MilitaryCardRepository militaryCardRepository) {
        this.militaryCardRepository = militaryCardRepository;
    }


    @Override
    public List<MilitaryCard> findAll() {
        return militaryCardRepository.findAll();
    }

    @Override
    public MilitaryCard findById(int theId) {
        return militaryCardRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(MilitaryCard militaryCard) {
        militaryCardRepository.save(militaryCard);
    }

    @Override
    public void deleteById(int theId) {
        militaryCardRepository.deleteById(theId);
    }
}
