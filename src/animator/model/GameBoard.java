package animator.model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.css.Rect;
import util.shapes.Rectangle;
import util.shapes.builder.RectangleBuilder;

// A class to represent the gameboard on which GOL is played
public class GameBoard implements GameModel {

  private int width;
  private int height;
  private int pixelSize;
  private Map<Point2D, GamePixel> pixelRegistry;

  /**
   * Constructor for the game of life board
   * @param width width of the gameboard in GamePixels
   * @param height height o gameboard in GamePixels
   * @param pixelSize the size of the GamePixels
   */
  public GameBoard(int width, int height, int pixelSize){
    this.width = width;
    this.height = height;
    this.pixelSize = pixelSize;
    pixelRegistry = new HashMap<>();
    for(int h = 0; h <= height; h++){
      for(int w = 0; w <= width; w++){
        Rectangle rect = new RectangleBuilder().setColor(Color.BLACK)
            .setPosition(new Point2D.Double(w * pixelSize, h * pixelSize))
            .setHeight(pixelSize).setWidth(pixelSize).build();
        pixelRegistry.putIfAbsent(new Point2D.Double(w, h), new GamePixel(rect, false));
      }
    }

  }

  @Override
  public void setBlockSize(int size) {
    this.pixelSize = size;
  }

  @Override
  public int[] getBounds() {
    return new int[]{this.width, this.height};
  }

  @Override
  public Map<Point2D, GamePixel> getShapes() {
    return this.pixelRegistry;
  }

  @Override
  public int getBlockSize() {
    return 0;
  }

  @Override
  public GamePixel getShapeAtPoint(Point2D point) {
    return pixelRegistry.get(point);
  }
}
