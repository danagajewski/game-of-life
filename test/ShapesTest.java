import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;
import util.shapes.Rectangle;

public class ShapesTest {

  // Test to make sure that a rectangle can't have more than 4 sides
  @Test (expected = IllegalArgumentException.class)
  public void testMoreSidesThanRectangle(){
    Rectangle rectangle = new Rectangle(Color.BLACK, new Point2D.Double(10,10), 1, 10, 10,
        new Point2D.Double(10, 10), new Point2D.Double(20, 10), new Point2D.Double(20, 20),
        new Point2D.Double(10, 20), new Point2D.Double(11, 20));
  }

  // Test to make sure that a rectangle can't have fewer than 4 sides
  @Test (expected = IllegalArgumentException.class)
  public void testLessSidesThanRectangle(){
    Rectangle rectangle = new Rectangle(Color.BLACK, new Point2D.Double(10,10), 1, 10, 10,
        new Point2D.Double(10, 10), new Point2D.Double(20, 10), new Point2D.Double(20, 20));
  }

  // Test to make sure that a rectangle can't have fewer than 4 sides
  @Test
  public void testProperCreationOfRectangle(){
    Rectangle rectangle = new Rectangle(Color.BLACK, new Point2D.Double(10,10), 1, 10, 10,
        new Point2D.Double(10, 10), new Point2D.Double(20, 10), new Point2D.Double(20, 20),
        new Point2D.Double(10, 20));

    assertEquals(rectangle.getHeight(), 10, .001);
  }

}
