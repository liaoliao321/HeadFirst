package com.company.chapter_3_decoratorModel.decorators;

import com.company.chapter_3_decoratorModel.base.Beverage;
import com.company.chapter_3_decoratorModel.base.CondimentDecorator;

public class Zhenzhu extends CondimentDecorator {
    private double price = 2;

    public Zhenzhu(Beverage beverage) {
        this(beverage,1);
    }

    public Zhenzhu(Beverage beverage,int multiple) {
        super.beverage = beverage;
        super.multiple = multiple;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +"珍珠    "+multiple+"    ￥"+(price)+"\n";
    }

    @Override
    public double cost() {
        return price*multiple+beverage.cost();
    }
}
