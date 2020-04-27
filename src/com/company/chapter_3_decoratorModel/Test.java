package com.company.chapter_3_decoratorModel;

import com.company.chapter_3_decoratorModel.base.Beverage;
import com.company.chapter_3_decoratorModel.beverages.Espresso;
import com.company.chapter_3_decoratorModel.beverages.RedTea;
import com.company.chapter_3_decoratorModel.decorators.Mocha;
import com.company.chapter_3_decoratorModel.decorators.Whip;
import com.company.chapter_3_decoratorModel.decorators.Yeguo;
import com.company.chapter_3_decoratorModel.decorators.Zhenzhu;

public class Test {
    public static void main(String[] args) {

        Beverage espresso = new Espresso();
        espresso = new Mocha(espresso);
        espresso = new Whip(espresso);
        System.out.println(espresso.getDescription()+" : "+espresso.cost());


        Beverage redTea = new RedTea(200);
        redTea = new Yeguo(redTea,2);
        redTea = new Zhenzhu(redTea);
        printBillInfo(redTea);

    }


    private static void printBillInfo(Beverage beverage){
        System.out.println("品名    数量  单价");
        System.out.println("-----------------");

        System.out.println(beverage.getDescription());
        System.out.println("-----------------");
        System.out.println("总价：￥"+beverage.cost());
    }
}
