package com.lavesh.design.patterns.openclose;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/7/18
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IProductFilter<T> {

    public Stream<T> filter(List<T> items, Specification<T> spec);
}
