package com.lavesh.design.patterns.openclose;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/7/18
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class ColorSpecification implements Specification<Product> {

    Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.color == color;
    }
}
