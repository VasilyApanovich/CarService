package patterns_demo.facade.shapes.impl;

import patterns_demo.facade.shapes.abstr.Shape;

/**
 * Created by apano on 10.03.2017.
 */
public class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("rectangle drawn");
    }
}
