package com.dmitry.university.service;

import com.dmitry.university.model.IdentityCard.MilitaryCard;

import java.util.List;

public interface MilitaryCardService {
    public List<MilitaryCard> findAll();

    public MilitaryCard findById(int theId);

    public void save(MilitaryCard theEmployee);

    public void deleteById(int theId);
}
