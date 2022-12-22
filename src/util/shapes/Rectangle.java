package util.shapes;

import animator.model.ReadOnlyGame;
import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A class that implements Shape and represents a rectangle
 */
public class Rectangle extends DefinedShape implements Shape {

  // Constructor for a rectangle
  public Rectangle(Color color, Point2D pos, float opacity, int height, int width,
      Point2D... vertices){
    super(color, pos, opacity, vertices, height, width);
    if(vertices.length != 4){
      throw new IllegalArgumentException("Rectangle must have 4 sides");
    }
  }

  /**
   * Returns the color of the rectangle
   * @return The color
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Returns the shape type of the rectangle
   * @return the shape type
   */
  @Override
  public ShapeType getShapeType() {
    return ShapeType.RECTANGLE;
  }

  /**
   * Returns the position of the shape with the top left corner as the position
   * @return the position
   */
  @Override
  public Point2D getPosition() {
    return this.pos;
  }

  /**
   * Returns the list of vertices of the rectangle
   * @return the vertices
   */
  @Override
  public Point2D[] getVertices() {
    return this.vertices;
  }

  /**
   * The opacity of the rectangle
   * @return the opacity
   */
  @Override
  public float getOpacity() {
    return this.opacity;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Setter for the color of the rectanhle
   * @param color the color for the shape to be
   */
  @Override
  public void setColor(Color color) {
    this.color = color;
  }

}
