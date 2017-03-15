package patterns_demo.facade;

import patterns_demo.facade.shapes.ShapeMaker;

/**
 * Created by apano on 10.03.2017.
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawRectangle();
    }
}
