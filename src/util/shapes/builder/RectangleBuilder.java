package util.shapes.builder;

import java.awt.Color;
import java.awt.geom.Point2D;
import util.shapes.Rectangle;
import util.shapes.Shape;

public class RectangleBuilder {

  private Color color;
  private Point2D pos;
  private float opacity;
  private int height;
  private int width;
  private Point2D[] vertices;

  /**
   * Constructor for a shape builder. The default shape builder returns the following shape:
   * Black square, positioned at (0, 0) with length 1
   */
  public RectangleBuilder() {
    this.color = new Color(0, 0, 0);
    this.pos = new Point2D.Double(0,0);
    this.opacity = 1;
    this.width = 2;
    this.height = 2;

  }

  /**
   * Set the color of the shape using a color object.
   * @param color a color object
   * @return an updated shape builder
   */
  public RectangleBuilder setColor(Color color) {
    this.color = new Color(color.getRGB());
    return this;
  }

  /**
   * Set the color of the shape using RGB values between 0 and 255.
   * @param red the red value
   * @param green the green value
   * @param blue the blue value
   * @return and updated shape builder
   * @throws IllegalArgumentException if RGB values are out of bounds
   */
  public RectangleBuilder setColor(int red, int green, int blue) {
    // check bounds of ints
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("RGB values need to be integers between 0 and 255");
    }
    this.color = new Color(red, green, blue);
    return this;
  }

  /**
   * Set the transparency of the shape using a float value between 0 and 1.
   * @param opacity the opacity value
   * @return an updated shape builder
   * @throws IllegalArgumentException if opacity value is out of bounds
   */
  public RectangleBuilder setOpacity(float opacity) {
    this.opacity = opacity;
    return this;
  }

  /**
   * Set the position of the shape given a Point2D object.
   * @param pos the center of the shape
   * @return an updated shape builder
   */
  public RectangleBuilder setPosition(Point2D pos) {
    if (pos == null) {
      throw new IllegalArgumentException("Position can't be null");
    }
    this.pos = pos;
    return this;
  }

  /**
   * Set the position of the shape given an x and y value.
   * @param x the x coordinate
   * @param y the y coordinate
   * @return an updated shape builder
   */
  public RectangleBuilder setPosition(int x, int y) {
    this.pos = new Point2D.Double(x, y);
    return this;
  }

  /**
   * Set the height of the shape, if vertices have not been specified yet.
   * @param height the height of the desired shape
   * @return an updated shape builder
   */
  public RectangleBuilder setHeight(int height) {
    if (height <= 0) {
      throw new IllegalArgumentException("Height should be positive");
    }
    this.height = height;
    return this;
  }

  /**
   * Set the width of the shape, if vertices have not been specified yet.
   * @param width the width of the desired shape
   * @return an update shape builder
   */
  public RectangleBuilder setWidth(int width) {
    if (width <= 0) {
      throw new IllegalArgumentException("Width should be positive");
    }
    this.width = width;
    return this;
  }

  /**
   * Sets the builder values to the passed in shape.
   * @param rect the shape to set the builder state to
   * @return an updated shape builder
   */
  public RectangleBuilder defaultRectangle(Shape rect) {
    return this.setPosition(rect.getPosition())
        .setColor(rect.getColor())
        .setOpacity(rect.getOpacity())
        .setWidth(rect.getWidth())
        .setHeight(rect.getHeight());
  }

  /**
   * Given the initial and updated states of the shape builder, build a shape.
   * @return A new instance of a shape with desired attributes
   */
  public Rectangle build() {

    // check that all values were set before building
    if (this.vertices == null) {
      throw new IllegalStateException("The set of vertices for the shape have not been specified");
    }

    Point2D[] vertices = new Point2D[]{pos,
        new Point2D.Double((int) (pos.getX() + this.width), (int) pos.getY()),
        new Point2D.Double((int) (pos.getX() + this.width), (int) pos.getY() - this.height),
        new Point2D.Double((int) pos.getX(), (int) pos.getY() - this.height)};

    Rectangle returnShape = new Rectangle(this.color, this.pos, this.opacity, this.height, this.width, vertices);

    // reset builder state
    this.color = new Color(0, 0, 0);
    this.pos = new Point2D.Double(0,0);
    this.opacity = 1;
    this.vertices = null;
    this.width = 2;
    this.height = 2;

    return returnShape;
  }

}
