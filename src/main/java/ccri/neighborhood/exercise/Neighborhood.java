package ccri.neighborhood.exercise;

import java.util.Iterator;

/**
 * Rectangular region divided into cells containing integral values.
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class Neighborhood implements Iterable<Location> {

  int width;

  int height;

  int[][] neighborhoodArray;

  /**
   * Creates a rectangular neighborhood with specified width and height.
   * @param width width of the neighborhood
   * @param height height of the neighborhood
   * @throws IllegalArgumentException if width or height &lt; 0
   */
  public Neighborhood(int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException(
          String.format(
              "Neighborhood width and height must each be > 0. Received width=%d, height=%d",
              width,
              height
          )
      );
    }
    this.width = width;
    this.height = height;
    this.neighborhoodArray = new int[width][height];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getValueAtLocation(Location location) {
    return this.neighborhoodArray[location.getX()][location.getY()];
  }

  public void setValueAtLocation(Location location, int value) {
    this.neighborhoodArray[location.getX()][location.getY()] = value;
  }

  /**
   * Gets iterator that iterates over every location in the neighborhood.
   * @return the iterator
   */
  @Override
  public Iterator<Location> iterator() {
    return new NeighborhoodIterator(this, new Location(0, 0));
  }

  /**
   * Gets iterator that iterates over every neighbor within the specified distance of the
   * specified location.
   * @param centerLocation location around which neighbors are retrieved
   * @param neighborThreshold distance from center location
   * @return the iterator
   */
  public Iterator<Location> neighborIterator(Location centerLocation, int neighborThreshold) {
    return new NeighborIterator(this, centerLocation, neighborThreshold);
  }

}
