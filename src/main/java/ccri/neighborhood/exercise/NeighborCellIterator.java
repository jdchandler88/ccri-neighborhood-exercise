package ccri.neighborhood.exercise;

import java.util.Iterator;

/**
 * Iterates over Cells within a specified Manhattan Distance of the supplied Cell.
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class NeighborCellIterator implements Iterator<Cell> {

  private Neighborhood neighborhood;

  private Location centerLocation;

  int neighborThreshold;

  int currentX;

  int currentY;

  /**
   * Creates a NeighborCellIterator. This iterates over the neighbors within the specified Manhattan
   * distance of the centerLocation.
   * @param neighborhood neighborhood inside of which the cells are located
   * @param centerLocation location at which the center cell is located. All cells iterated are
   *                       neighbors of this cell. NOTE: this also includes the center cell
   * @param neighborThreshold distance from center cell. If a cell is within this distance to the
   *                          center cell, then it will be returned by this iterator
   */
  public NeighborCellIterator(Neighborhood neighborhood, Location centerLocation,
                              int neighborThreshold) {
    this.neighborhood = neighborhood;
    this.centerLocation = centerLocation;
    this.neighborThreshold = neighborThreshold;
    this.currentX = centerLocation.getX() - neighborThreshold;
    this.currentY = centerLocation.getY() - neighborThreshold;
  }

  @Override
  public boolean hasNext() {
    while (hasMorePossibleNeighbors()) {
      Location currentLocation = new Location(this.currentX, this.currentY);
      if (isValidNeighborLocation(currentLocation)) {
        return true;
      } else {
        advanceCursor();
      }
    }
    return false;
  }

  @Override
  public Cell next() {
    Location location = new Location(currentX, currentY);
    advanceCursor();
    return neighborhood.getCellAtLocation(location);
  }

  private boolean hasMorePossibleNeighbors() {
    return currentX <= (centerLocation.getX() + neighborThreshold)
        && currentY <= (centerLocation.getY() + neighborThreshold);
  }

  private boolean isValidNeighborLocation(Location location) {
    return isWithinManhattanDistanceFromCenterLocation(location)
        && isWithinNeighborhoodBounds(location);
  }

  private void advanceCursor() {
    if (isAtEndOfCurrentRow()) {
      moveCursorToNextRow();
    } else {
      moveCursorToNextColumn();
    }
  }

  private boolean isAtEndOfCurrentRow() {
    return currentX == centerLocation.getX() + neighborThreshold;
  }

  private void moveCursorToNextRow() {
    currentX = this.centerLocation.getX() - this.neighborThreshold;
    currentY++;
  }

  private void moveCursorToNextColumn() {
    currentX++;
  }

  private boolean isWithinManhattanDistanceFromCenterLocation(Location location) {
    int distanceX = Math.abs(centerLocation.getX() - location.getX());
    int distanceY = Math.abs(centerLocation.getY() - location.getY());
    return distanceX + distanceY <= neighborThreshold;
  }

  private boolean isWithinNeighborhoodBounds(Location location) {
    int x = location.getX();
    int y = location.getY();
    return x >= 0 && x < neighborhood.getWidth()
        && y >= 0 && y < neighborhood.getHeight();
  }

}
