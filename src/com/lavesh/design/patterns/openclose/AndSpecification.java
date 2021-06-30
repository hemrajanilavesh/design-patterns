package com.lavesh.design.patterns.openclose;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/19/18
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AndSpecification<T> implements Specification<T> {

    Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}
