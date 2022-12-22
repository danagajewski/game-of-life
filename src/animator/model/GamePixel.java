package animator.model;

import java.awt.Color;
import util.shapes.Rectangle;

/**
 * A class to represent each pixel on the game board
 */
public class GamePixel {

  private Rectangle pixel;
  private boolean lit;
  private final int xpos;
  private final int ypos;

  // Constructor for a game pixel
  public GamePixel(Rectangle pixel, boolean lit, int xpos, int ypos){

    this.pixel = pixel;
    this.lit = lit;
    this.xpos = xpos;
    this.ypos = ypos;

  }

  /**
   * Getter for if the pixel is lit or not
   * @return boolean if the pixel is lit
   */
  public boolean getLit(){
    return this.lit;
  }

  /**
   * Returns the pixel
   * @return Rectangle (The pixel's shape)
   */
  public Rectangle getPixel(){
    return this.pixel;
  }

  /**
   * Sets the color of the pixel to black for unlit
   */
  public void setPixelUnlit(){
    this.pixel.setColor(Color.BLACK);
  }

  /**
   * Sets the color of the pixel to white for lit
   */
  public void setPixelLit(){
    this.pixel.setColor(Color.WHITE);
  }

  public int getXpos(){
    return this.xpos;
  }

  public int getYpos(){
    return this.ypos;
  }

}
