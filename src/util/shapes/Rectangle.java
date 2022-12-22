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
    if(vertices.length != 4){
      throw new IllegalArgumentException("Rectangle must have 4 sides");
    }
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public ShapeType getShapeType() {
    return ShapeType.RECTANGLE;
  }

  @Override
  public Point2D getPosition() {
    return this.pos;
  }

  @Override
  public Point2D[] getVertices() {
    return this.vertices;
  }

  @Override
  public float getOpacity() {
    return this.opacity;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public double getWidth() {
    return this.width;
  }
}
