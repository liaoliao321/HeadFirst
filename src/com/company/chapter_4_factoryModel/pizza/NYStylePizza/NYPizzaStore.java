package com.company.chapter_4_factoryModel.pizza.NYStylePizza;

import com.company.chapter_4_factoryModel.base.Pizza;
import com.company.chapter_4_factoryModel.base.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new NYStyleCheesePizza();
                break;
            case "veggie":
                pizza = new NYStyleVeggiePizza();
                break;
            case "clam":
                pizza = new NYStyleClamPizza();
                break;
            default:
//                pizza = new NYStyleDefaultPizza();

        }
        return pizza;
    }
}
