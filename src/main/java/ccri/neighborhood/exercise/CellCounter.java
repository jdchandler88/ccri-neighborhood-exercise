package ccri.neighborhood.exercise;

import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class counts the number of neighbors within a specified distance of cells containing a
 * positive number.
 */
public final class CellCounter {

  /**
   * Prevent instantiation.
   */
  private CellCounter() {
  }

  /**
   * Counts the number of cells that are within the specified distance of cells that have a positive
   * value. Even though some cells could be 'activated' or counted more than once, this returns the
   * total number of cells within the specified distance. This distance is the "Manhattan Distance"
   * @param neighborhood neighborhood containing cells
   * @param neighborDistance distance from cell with positive value that a cell will be counted
   * @return
   */
  public static int countUniqueCellsWithinDistanceOfActiveCells(Neighborhood neighborhood,
                                                                int neighborDistance) {
    return (int)
        getNeighborhoodCellStream(neighborhood)
            .filter(CellCounter::isCellWithPositiveValue)
            .flatMap(cellWithPositiveValue -> getAllNeighborsWithinDistanceStream(neighborhood,
                neighborDistance, cellWithPositiveValue))
            .map(CellCounter::countCell)
            .filter(CellCounter::isCellCountedOnlyOnce)
            .count();
  }

  private static Stream<Cell> getNeighborhoodCellStream(Neighborhood neighborhood) {
    return StreamSupport.stream(neighborhood.spliterator(), false);
  }

  private static boolean isCellWithPositiveValue(Cell cell) {
    return cell.getValue() > 0;
  }

  private static Stream<Cell> getAllNeighborsWithinDistanceStream(Neighborhood neighborhood,
                                                                  int neighborDistance,
                                                                  Cell center) {
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
        neighborhood.neighborIterator(center.getLocation(), neighborDistance), 0), false);
  }

  private static Cell countCell(Cell cell) {
    cell.incrementCount();
    return cell;
  }

  private static boolean isCellCountedOnlyOnce(Cell cell) {
    return cell.getTimesCounted() == 1;
  }

}
