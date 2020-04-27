package com.company.chapter_3_decoratorModel.beverages;

import com.company.chapter_3_decoratorModel.base.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
