package animator.model;

import java.awt.geom.Point2D;
import java.util.Map;

/**
 * This is a read only model for the view to enforce MVC. This is the interface for the game of the
 * Game of Life
 */
public interface ReadOnlyGame {

  /**
   * Gets the bounds of the game board
   * @return int array (int width, int height)
   */
  int[] getBounds();

  /**
   * Get the list of all shapes on the board.
   * @return the list of all the shapes for the game
   */
  Map<Point2D, GamePixel> getShapes();

  /**
   * Get the size of the edge of blocks
   * @return int (the size)
   */
  int getBlockSize();

  /**
   * Get the shape at the given location
   * @param point the location of the place we are trying to go
   * @return The chape at that point
   */
  GamePixel getShapeAtPoint(Point2D point);

}
