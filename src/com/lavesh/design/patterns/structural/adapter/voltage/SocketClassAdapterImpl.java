package com.lavesh.design.patterns.structural.adapter.voltage;

/**
 * Class Adapter approach to create an adapter between source socket and target socket
 */
public class SocketClassAdapterImpl extends Socket implements ISocketAdapter {

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt().getVolts(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt().getVolts(), 10);
    }

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    private Volt convertVolt(int currentVoltage, int divideBy) {
        return new Volt(currentVoltage / divideBy);
    }

}
