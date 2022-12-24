package animator.model;

public interface GameModel extends ReadOnlyGame{


  /**
   * Sets the size of the blocks in the game board
   * @param size the length of edge of shape in pixels
   */
  void setBlockSize(int size);

}
