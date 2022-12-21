package animator.model;

public interface GameModel extends ReadOnlyGame{

  /**
   * Sets the bounds of the game in terms of number of blocks in x and y directions
   * @param width Width of the game board
   * @param height Height of the game board
   */
  void setBounds(int width, int height);

  /**
   * Sets the size of the blocks in the game board
   * @param size the length of edge of shape in pixels
   */
  void setBlockSize(int size);

}
