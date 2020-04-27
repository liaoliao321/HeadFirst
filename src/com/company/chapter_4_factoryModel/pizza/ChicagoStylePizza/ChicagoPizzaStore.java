package com.company.chapter_4_factoryModel.pizza.ChicagoStylePizza;

import com.company.chapter_4_factoryModel.base.Pizza;
import com.company.chapter_4_factoryModel.base.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {

        switch (type) {
            case "cheese":break;
            case "veggie":break;
            case "clam":break;
        }


        return null;
    }
}
