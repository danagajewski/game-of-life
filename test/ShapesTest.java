import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;
import util.shapes.Rectangle;
import util.shapes.builder.RectangleBuilder;

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

  //Test to make sure that setting the color of a shape does so
  @Test
  public void testCorrectSettingOfColor(){
    Rectangle rectangle = new Rectangle(Color.BLACK, new Point2D.Double(10,10), 1, 10, 10,
        new Point2D.Double(10, 10), new Point2D.Double(20, 10), new Point2D.Double(20, 20),
        new Point2D.Double(10, 20));

    rectangle.setColor(Color.WHITE);
    assertEquals(rectangle.getColor(), Color.WHITE);
  }

  // Test the rectangle builder
  @Test
  public void testCorrectRectangleBuilderOutput(){
    Rectangle rectangle = new Rectangle(Color.BLACK, new Point2D.Double(10,10), 1, 10, 10,
        new Point2D.Double(10, 10), new Point2D.Double(20, 10), new Point2D.Double(20, 20),
        new Point2D.Double(10, 20));

    Rectangle built = new RectangleBuilder().setColor(Color.BLACK)
        .setPosition(new Point2D.Double(10,10)).setHeight(10).setWidth(10).build();

    assertEquals(rectangle, built);

  }

  //Test to make sure that two different builders create different shapes
  @Test
  public void testDifferentBuildersObjectsDiffer(){
    Rectangle rect1 = new RectangleBuilder().setColor(Color.RED).build();
    Rectangle rect2 = new RectangleBuilder().setColor(Color.WHITE).build();

    assertNotEquals(rect1, rect2);
  }

}
