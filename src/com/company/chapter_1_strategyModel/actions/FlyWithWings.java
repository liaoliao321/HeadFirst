package com.company.chapter_1_strategyModel.actions;

import com.company.chapter_1_strategyModel.base.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("插上翅膀，自由翱翔~");
    }
}
