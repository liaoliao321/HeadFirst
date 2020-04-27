package com.company.chapter_4_factoryModel.pizza.NYStylePizza;

import com.company.chapter_4_factoryModel.base.Pizza;

public class NYStyleClamPizza extends Pizza {

    public NYStyleClamPizza() {
        name = "NY style Sauce and Clam Pizza";
        dough = "Thickness Crust Dough";
        sauce = "Peanut Sauce";

        toppings.add("Grated Lettuce");
        toppings.add("Grated Chopped Green Onion");
    }
}
