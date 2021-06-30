package com.lavesh.design.patterns.openclose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/7/18
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppMain {

       public static void main(String[] args) {
           Product p1 = new Product("Surface Pro", Color.BLUE, Size.MEDIUM);
           Product p2 = new Product("MacBook Pro", Color.BLUE, Size.SMALL);
           Product p3 = new Product("Lenevo ThinkPad", Color.RED, Size.LARGE);

           List<Product> products = new ArrayList<>();
           products.add(p1);
           products.add(p2);
           products.add(p3);

           ColorSpecification colorSpecification = new ColorSpecification(Color.BLUE);
           SizeSpecification sizeSpecification = new SizeSpecification(Size.SMALL);
           AndSpecification andSpecification = new AndSpecification(colorSpecification, sizeSpecification);
           ProductFilter productFilter = new ProductFilter();
           productFilter.filter(products,andSpecification).forEach(p -> System.out.println(p));
       }

}
