package util.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class DefinedShape implements Shape {

  protected final Color color;
  protected final Point2D pos;
  protected final float opacity;
  protected final Point2D[] vertices;
  protected final double height;
  protected final double width;

  public DefinedShape(Color color, Point2D pos, float opacity, Point2D[] vertices, double height,
      double width){
    //Check Values
    if(opacity < 0 || opacity > 1){
      throw new IllegalArgumentException("Opacity out of bounds of [0,1]");
    }
    if(pos.getX() < 0 || pos.getY() < 0) {
      throw new IllegalArgumentException("Position cannot be negative");
    }
    for(Point2D vertex : vertices){
      if(vertex.getY() < 0 || vertex.getX() < 0){
        throw new IllegalArgumentException("Vertex cannot be less than 0 in either axis");
      }
    }


    this.color = color;
    this.pos = pos;
    this.opacity = opacity;
    this.vertices = vertices;
    this.height = height;
    this.width = width;
  }

  @Override
  public Color getColor() {
    return new Color(this.color.getRGB());
  }

  @Override
  public Point2D getPosition() {
    return new Point2D.Double(this.pos.getX(), this.pos.getY());
  }

  @Override
  public Point2D[] getVertices() {
    return this.vertices;
  }

  @Override
  public float getOpacity() {
    return opacity;
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    ArbitraryShape that = (ArbitraryShape) o;
//    return Float.compare(that.opacity, opacity) == 0 && rotation == that.rotation && color
//        .equals(that.color) && pos.equals(that.pos) && Arrays.equals(vertices, that.vertices);
//  }

  @Override
  public int hashCode() {
    int result = Objects.hash(color, pos, opacity);
    result = 31 * result + Arrays.hashCode(vertices);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%d %d %d %d %d %d %d", (long) this.pos.getX(),
        (long) this.pos.getY(), (long) this.width, (long) this.height, this.color.getRed(),
        this.color.getGreen(), this.color.getBlue());
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
