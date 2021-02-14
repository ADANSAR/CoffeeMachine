package com.coffeemachine.interfaces;

import java.util.List;

import com.coffeemachine.model.SoldItemsEntity;

public interface SoldItemsRepository {

    void save(SoldItemsEntity soldItem);

    List<SoldItemsEntity> findAll();

}