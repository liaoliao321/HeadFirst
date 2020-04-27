package com.company.chapter_1_strategyModel;

import com.company.chapter_1_strategyModel.base.Duck;
import com.company.chapter_1_strategyModel.ducks.WithDuck;

public class Test {
    public static void main(String[] args) {


        Duck withDuck = new WithDuck();
//        多态调用
        withDuck.performFly();
        withDuck.performQuack();
    }
}
