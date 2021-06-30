package com.lavesh.design.patterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

interface Human {
    void walk();
    void talk();
}

class Person implements Human {
    @Override
    public void walk() {
        System.out.println("Person is walking");
    }

    @Override
    public void talk() {
        System.out.println("Person is talking");
    }
}

class LoggingHandler implements InvocationHandler {

    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        if (methodName.contains("toString")) {
            return calls.toString();
        }
        calls.merge(methodName,1,Integer::sum);
        return method.invoke(target,args);  //To change body of implemented methods use File | Settings | File Templates.
    }
}


public class DynamicProxy {

    public static <T> T withLogging(T target,Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class[]{itf},
                new LoggingHandler(target)
        );

    }

    public static void main(String[] args) {
        Person person = new Person();
        Human human = withLogging(person, Human.class);
        human.talk();
        human.walk();
        human.talk();
        human.walk();

        System.out.println(human.toString());


    }

}
