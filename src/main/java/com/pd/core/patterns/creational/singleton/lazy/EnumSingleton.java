package com.pd.core.patterns.creational.singleton.lazy;

public enum EnumSingleton {
    INSTANCE;
    public void doStuff(){
        System.out.println("Singleton using Enum");
    }
   }