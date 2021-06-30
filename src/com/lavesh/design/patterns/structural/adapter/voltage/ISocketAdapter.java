package com.lavesh.design.patterns.structural.adapter.voltage;

public interface ISocketAdapter {
    public Volt get3Volt();
    public Volt get12Volt();
    public Volt get120Volt();
}
