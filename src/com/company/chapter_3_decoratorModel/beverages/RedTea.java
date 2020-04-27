package com.company.chapter_3_decoratorModel.beverages;

import com.company.chapter_3_decoratorModel.base.Beverage;

public class RedTea extends Beverage {
    private double price = 4;
    public RedTea() {
        this(1);
    }

    public RedTea(int multiple) {
        super.multiple = multiple;
        description = "红茶    "+super.multiple+"    ￥"+price+"\n";
    }

    @Override
    public double cost() {
        return 4*super.multiple;
    }
}
