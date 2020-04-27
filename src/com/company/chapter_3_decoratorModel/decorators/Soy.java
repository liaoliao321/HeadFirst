package com.company.chapter_3_decoratorModel.decorators;

import com.company.chapter_3_decoratorModel.base.Beverage;
import com.company.chapter_3_decoratorModel.base.CondimentDecorator;

public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +" , Soy(豆浆)";
    }

    @Override
    public double cost() {
        return .15+beverage.cost();
    }
}
