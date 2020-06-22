package ccri.neighborhood.exercise;

import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Collectors;
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
   * @return count of neighbors within distance of positive cells
   */
  public static int countUniqueCellsWithinDistanceOfActiveCells(Neighborhood neighborhood,
                                                                int neighborDistance) {
    return
        CellCounter.getNeighborhoodLocationStream(neighborhood)
        .filter(location -> isCellWithPositiveValue(neighborhood, location))
        .flatMap(locationWithPositiveValue -> getAllNeighborsWithinDistanceStream(
            neighborhood,
            neighborDistance,
            locationWithPositiveValue)
        )
        .collect(Collectors.toSet())
        .size();

  }

  private static Stream<Location> getNeighborhoodLocationStream(Neighborhood neighborhood) {
    return StreamSupport.stream(neighborhood.spliterator(), false);
  }

  private static boolean isCellWithPositiveValue(Neighborhood neighborhood, Location location) {
    return neighborhood.getValueAtLocation(location) > 0;
  }

  private static Stream<Location> getAllNeighborsWithinDistanceStream(Neighborhood neighborhood,
                                                                  int neighborDistance,
                                                                  Location center) {
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
        neighborhood.neighborIterator(center, neighborDistance), 0), false);
  }

}
