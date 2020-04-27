package com.company.chapter_2_observerModel.observer;

import com.company.chapter_2_observerModel.base.DisplayElement;
import com.company.chapter_2_observerModel.base.Observer;
import com.company.chapter_2_observerModel.base.Subject;
//                                            代表这是观察者  代表要显示数据
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float pressure;

//    订阅主题
    public CurrentConditionsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("temperature: "+this.temperature+"\n"+"pressure: "+this.pressure);
    }
//     当主题有新数据传递过来时，在此处接收
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        this.temperature = temperature;
        display();
    }
}
