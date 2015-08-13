package com.pd.core.prepare.lang;

public class StaticMethod {

}

class BaseWithStaticMethod {
    public static void syout() {
	System.out.println("Base class");
    }
}

class NewOne extends BaseWithStaticMethod {
    public static void syout() {
	System.out.println("NewOne class");
    }
}