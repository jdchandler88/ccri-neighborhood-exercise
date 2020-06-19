package ccri.neighborhood.exercise;

import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class counts the number of neighbors within a specified distance of cells containing a positive number.
 */
public class CellCounter {

    private Neighborhood neighborhood;
    private int neighborDistance;

    /**
     * Prevent instantiation
     */
    public CellCounter(Neighborhood neighborhood, int neighborDistance) {
        this.neighborhood = neighborhood;
        this.neighborDistance = neighborDistance;
    }

    public static int countUniqueCellsWithinDistanceOfActiveCells(Neighborhood neighborhood, int neighborDistance) {
        return (int)
                getNeighborhoodLocationsStream(neighborhood)
                .filter(location -> isCellWithPositiveValue(neighborhood, location))
                .flatMap(locationWithPositiveValue -> getAllNeighborsWithinDistanceStream(neighborhood, neighborDistance, locationWithPositiveValue))
                .map(neighborOfPositiveValueCell -> getCellAtLocationAndCountIt(neighborhood, neighborOfPositiveValueCell))
                .filter(neighborCell -> isCellCountedOnlyOnce(neighborCell))
                .count();
    }

    private static Stream<Location> getNeighborhoodLocationsStream(Neighborhood neighborhood) {
        return StreamSupport.stream(neighborhood.spliterator(), false);
    }

    private static boolean isCellWithPositiveValue(Neighborhood neighborhood, Location location) {
        return neighborhood.getCellAtLocation(location).getValue() > 0;
    }

    private static Stream<Location> getAllNeighborsWithinDistanceStream(Neighborhood neighborhood, int  neighborDistance, Location center) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(neighborhood.neighborIterator(center, neighborDistance), 0), false);
    }

    private static Cell getCellAtLocationAndCountIt(Neighborhood neighborhood, Location location) {
        Cell cell = neighborhood.getCellAtLocation(location);
        cell.incrementCount();
        return cell;
    }

    private static boolean isCellCountedOnlyOnce(Cell cell) {
        return cell.getTimesCounted() == 1;
    }

}
