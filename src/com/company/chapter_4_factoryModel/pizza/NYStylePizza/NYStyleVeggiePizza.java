package com.company.chapter_4_factoryModel.pizza.NYStylePizza;

import com.company.chapter_4_factoryModel.base.Pizza;

public class NYStyleVeggiePizza extends Pizza {

    public NYStyleVeggiePizza() {
        name = "NY style Sauce and Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Tomato Sauce";

        toppings.add("Grated Lettuce");
    }
}
