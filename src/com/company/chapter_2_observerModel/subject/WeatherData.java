package com.company.chapter_2_observerModel.subject;

import com.company.chapter_2_observerModel.base.Observer;
import com.company.chapter_2_observerModel.base.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
//    维护一个观察者集合
    private List<Observer> observerList;
//    需要传递给所有观察者的数据
    private float pressure;
    private float humidity;
    private float temperature;

    public WeatherData() {
        observerList  = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) { observerList.add(observer); }
    @Override
    public void unRegisterObserver(Observer observer) {
            observerList.remove(observer);
    }

//    数据有更新时通知所有观察者
    @Override
    public void notifyObserver() {
        if (observerList.size()>0) {
            for (int i = 0; i < observerList.size(); i++) {
                observerList.get(i).update(this.temperature,this.humidity,this.pressure);
            }
        }
    }

    public void dataChange(){
        notifyObserver();
    }

    public void setData(float temperature,float humidity,float pressure){
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperature = temperature;
        dataChange();
    }
}
