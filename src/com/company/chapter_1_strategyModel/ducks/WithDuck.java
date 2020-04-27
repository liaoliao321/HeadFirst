package com.company.chapter_1_strategyModel.ducks;

import com.company.chapter_1_strategyModel.actions.FlyWithWings;
import com.company.chapter_1_strategyModel.actions.Quack;
import com.company.chapter_1_strategyModel.base.Duck;

public class WithDuck extends Duck {

    public WithDuck() {
//        组合行为，避免代码冗余
//        通过多态的方式 实例化接口，可以调用引用的方法
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
}
