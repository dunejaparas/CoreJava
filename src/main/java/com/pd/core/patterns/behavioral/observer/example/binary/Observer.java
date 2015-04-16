package com.pd.core.patterns.behavioral.observer.example.binary;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}