package com.company.chapter_3_decoratorModel.base;

public abstract class Beverage {

    protected int multiple;

    public String description = "Unknown Beverage";

    public String getDescription(){
        return this.description;
    }

    public abstract double cost();
}
