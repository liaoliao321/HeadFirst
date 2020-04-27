package com.company.chapter_1_strategyModel.base;

import com.company.chapter_1_strategyModel.base.FlyBehavior;
import com.company.chapter_1_strategyModel.base.QuackBehavior;

/*
设计原则，可变与不变代码分离，针对超类编程
将行为封装起来，Duck子类独立出来

1、父类不再提供行为，而是将行为组合而来
2、行为子类实现接口，得到真正的行为
3、子类在实例化的时候，将行为组合给父类
4、子类通过多态获得行为

 */
public class Duck {

   protected FlyBehavior flyBehavior;
   protected QuackBehavior quackBehavior;

   public void performFly(){
       flyBehavior.fly();
   }

    public void performQuack(){
       quackBehavior.quack();
   }

}
