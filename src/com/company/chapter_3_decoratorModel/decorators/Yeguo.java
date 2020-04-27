package com.company.chapter_3_decoratorModel.decorators;

import com.company.chapter_3_decoratorModel.base.Beverage;
import com.company.chapter_3_decoratorModel.base.CondimentDecorator;

public class Yeguo extends CondimentDecorator {
    private double price = 3;
    public Yeguo(Beverage beverage) {
        this(beverage,1);
    }

    public Yeguo(Beverage beverage,int multiple) {
        super.beverage = beverage;
        super.multiple = multiple;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription()+"椰果    "+multiple+"    ￥"+(price)+"\n";
    }

    @Override
    public double cost() {
        return price*multiple+beverage.cost();
    }
}
