package com.company.chapter_3_decoratorModel.base;

public abstract class CondimentDecorator  extends  Beverage{
  protected Beverage beverage;

  protected int multiple;
  public abstract String getDescription();
}
