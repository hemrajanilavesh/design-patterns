package com.lavesh.design.patterns.openclose;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/7/18
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductFilter implements IProductFilter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {

        return items.stream().filter(p -> spec.isSatisfied(p));  //To change body of implemented methods use File | Settings | File Templates.
    }
}
