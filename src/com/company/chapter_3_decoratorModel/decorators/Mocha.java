package com.company.chapter_3_decoratorModel.decorators;

import com.company.chapter_3_decoratorModel.base.Beverage;
import com.company.chapter_3_decoratorModel.base.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha() {
    }

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +" , Mocha";
    }

    @Override
    public double cost() {
        return .20+beverage.cost();
    }
}
