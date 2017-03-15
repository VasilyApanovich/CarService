package patterns_demo.facade.shapes;

import patterns_demo.facade.shapes.abstr.Shape;
import patterns_demo.facade.shapes.impl.Circle;
import patterns_demo.facade.shapes.impl.Rectangle;
import patterns_demo.facade.shapes.impl.Square;

/**
 * Created by apano on 10.03.2017.
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}
