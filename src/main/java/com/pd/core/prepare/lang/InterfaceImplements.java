package com.pd.core.prepare.lang;

public class InterfaceImplements {

}

interface Base
{
    boolean m1 ();
    byte m2(short s);
}

//Syntax error on token "implements", extends expected
// interface Base2 implements Base {}


//	The type Base cannot be the superclass of Class2; a superclass must be a class
// abstract class Class2 extends Base{
// public boolean m1(){ return true; }
// }


abstract class Class3 implements Base {}


abstract class Class4 implements Base{
    @Override
    public boolean m1(){ return (7 > 4); }
}


//Cannot reduce the visibility of the inherited method from Base
/*abstract class Class5 implements Base
{ @Override
    protected boolean m1(){ return (5 > 7) }}*/