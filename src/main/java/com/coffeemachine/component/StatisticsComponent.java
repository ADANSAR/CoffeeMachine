package com.coffeemachine.component;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.javamoney.moneta.Money;

import com.coffeemachine.interfaces.SoldItemsRepository;
import com.coffeemachine.model.SoldItemsEntity;
import com.coffeemachine.utils.DrinkType;

public class StatisticsComponent {

    final String currentCurrency = "EUR";

    public StatisticsComponent() {
        // Default constructor
    }

    public void printStatistics(SoldItemsRepository soldRepo) {
        List<SoldItemsEntity> soldItems = soldRepo.findAll();
        List<DrinkType> drinks = soldItems.stream().map(SoldItemsEntity::getSoldItemName)
                .map(DrinkType::getDrinkFromCode).collect(Collectors.toList());
        Map<DrinkType, List<DrinkType>> soldItemsByDrinkName = drinks.stream().collect(Collectors
                .groupingBy(Function.identity(), LinkedHashMap::new, Collectors.toList()));
        StringBuilder sb = new StringBuilder();
        sb.append("The sold items are : ");
        soldItemsByDrinkName.forEach((key, value) -> sb.append(value.size() + " "
                + (value.size() > 1 ? key.getName() + "s" : key.getName()) + " "));
        sb.append("with a total of : ");
        Optional<BigDecimal> totalAmount = drinks.stream().map(DrinkType::getCost)
                .map(Money::getNumberStripped).reduce((a, b) -> a.add(b));
        if (totalAmount.isPresent()) {
            sb.append(totalAmount.get());
        } else {
            sb.append("0");
        }
        sb.append(currentCurrency);
        System.out.print(sb.toString());
    }
}