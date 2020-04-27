package com.company.chapter_4_factoryModel;

import com.company.chapter_4_factoryModel.base.Pizza;
import com.company.chapter_4_factoryModel.pizza.NYStylePizza.NYPizzaStore;

public class Test {
    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ayjia order a "+pizza.getName()+"\n");
    }
}
