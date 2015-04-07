package com.pd.core.patterns.structural.adapter.ex1;

/**
 *
 Two Way Adapter Pattern
 *
 * While implementing Adapter pattern, there are two approaches – class adapter
 * and object adapter, however both these approaches produce same result.
 *
 * Class Adapter – This form uses java inheritance and extends the source
 * interface, in our case Socket class. Object Adapter – This form uses Java
 * Composition and adapter contains the source object.
 * 
 * Notice that both the adapter implementations are almost same and they
 * implement the SocketAdapter interface. The adapter interface can also be an
 * abstract class.
 *
 */

// Using inheritance for adapter pattern
public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
	return getVolt();
    }

    @Override
    public Volt get12Volt() {
	final Volt v = getVolt();
	return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
	final Volt v = getVolt();
	return convertVolt(v, 40);
    }

    private Volt convertVolt(final Volt v, final int i) {
	return new Volt(v.getVolts() / i);
    }

}