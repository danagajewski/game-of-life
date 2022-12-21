package util.shapes;

import animator.model.ReadOnlyGame;
import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A class that implements Shape and represents a rectangle
 */
public class Rectangle extends DefinedShape implements Shape {



  public Rectangle(Color color, Point2D pos, float opacity, double height, double width,
      Point2D... vertices){
    super(color, pos, opacity, vertices, height, width);


  }

  @Override
  public Color getColor() {
    return null;
  }

  @Override
  public ShapeType getShapeType() {
    return null;
  }

  @Override
  public Point2D getPosition() {
    return null;
  }

  @Override
  public Point2D[] getVertices() {
    return new Point2D[0];
  }

  @Override
  public float getOpacity() {
    return 0;
  }

  @Override
  public double getHeight() {
    return 0;
  }

  @Override
  public double getWidth() {
    return 0;
  }
}
