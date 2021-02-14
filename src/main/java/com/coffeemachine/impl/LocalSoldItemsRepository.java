package com.coffeemachine.impl;

import java.util.ArrayList;
import java.util.List;

import com.coffeemachine.interfaces.SoldItemsRepository;
import com.coffeemachine.model.SoldItemsEntity;

public class LocalSoldItemsRepository implements SoldItemsRepository {

    private final List<SoldItemsEntity> soldItems;

    public LocalSoldItemsRepository() {
        soldItems = new ArrayList<>();
    }

    @Override
    public void save(SoldItemsEntity soldItem) {
        soldItems.add(soldItem);
    }

    @Override
    public List<SoldItemsEntity> findAll() {
        return soldItems;
    }

}
