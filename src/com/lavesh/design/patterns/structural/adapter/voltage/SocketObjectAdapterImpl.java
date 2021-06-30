package com.lavesh.design.patterns.structural.adapter.voltage;

/**
 * Composition approach to create adapter between source socket and target socket
 */
public class SocketObjectAdapterImpl implements ISocketAdapter {

    private Socket socket = new Socket();

    @Override
    public Volt get3Volt() {
        return convertVolt(socket.getVolt().getVolts(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(socket.getVolt().getVolts(), 10);
    }

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    private Volt convertVolt(int currentVoltage, int divideBy) {
        return new Volt(currentVoltage / divideBy);
    }
}
