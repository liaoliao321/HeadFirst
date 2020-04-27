package com.company.chapter_3_decoratorModel.decorators;

import com.company.chapter_3_decoratorModel.base.Beverage;
import com.company.chapter_3_decoratorModel.base.CondimentDecorator;

public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +" , Whip(奶泡)";
    }

    @Override
    public double cost() {
        return .10+beverage.cost();
    }
}
