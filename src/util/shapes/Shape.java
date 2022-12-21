package util.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * An interface to represent all types of shapes
 */
public interface Shape {

  /**
   * Get the color of a shape.
   * @return a color object
   */
  Color getColor();

  /**
   * Get the type of the shape.
   * @return a ShapeType enum
   */
  ShapeType getShapeType();

  /**
   * Get the position of the shape.
   * @return a Point2D (with double precision)
   */
  Point2D getPosition();

  /**
   * Get the vertices that define the shape.
   * @return an array of Point2D objects (with double precision)
   */
  Point2D[] getVertices();

  /**
   * Get the transparency of the shape as a value between 0 (transparent) and 1 (opaque).
   * @return opacity float
   */
  float getOpacity();

  /**
   * Get the height of the shape (vertical distance from highest to lowest vertex).
   * @return height distance
   */
  double getHeight();

  /**
   * Get the width of the shape (horizontal distance from the left-most and right-most vertex).
   * @return width distance
   */
  double getWidth();

  /**
   * An enumeration of supported types of shapes.
   */
  enum ShapeType {
    RECTANGLE,
    HEXAGON
  }

}
