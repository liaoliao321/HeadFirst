package com.company.chapter_1_strategyModel.actions;

import com.company.chapter_1_strategyModel.base.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱呱~");
    }
}
