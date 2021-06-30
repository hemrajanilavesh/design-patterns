package com.lavesh.design.patterns.openclose;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/7/18
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Specification<T> {

    public boolean isSatisfied(T item);
}
