package com.company.chapter_2_observerModel.base;

public interface Subject {
    void registerObserver(Observer observer);
    void unRegisterObserver(Observer observer);
    void notifyObserver();
}
