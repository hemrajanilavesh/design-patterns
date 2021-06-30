package com.lavesh.design.patterns.openclose;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/7/18
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SizeSpecification implements Specification<Product> {

    Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.size == size;
    }
}
