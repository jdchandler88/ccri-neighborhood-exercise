package ccri.neighborhood.exercise;

import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class counts the number of neighbors within a specified distance of cells containing a positive number.
 */
public final class CellCounter {

    /**
     * Prevent instantiation
     */
    private CellCounter() {}

    public static int countUniqueCellsWithinDistanceOfActiveCells(Neighborhood neighborhood, int neighborDistance) {
        return (int)
                getNeighborhoodCellStream(neighborhood)
                .filter(CellCounter::isCellWithPositiveValue)
                .flatMap(cellWithPositiveValue -> getAllNeighborsWithinDistanceStream(neighborhood, neighborDistance, cellWithPositiveValue))
                .map(CellCounter::countCell) //this doesn't ACTUALLY map a Cell to another type. It performs an operation on it and returns it
                .filter(CellCounter::isCellCountedOnlyOnce)
                .count();
    }

    private static Stream<Cell> getNeighborhoodCellStream(Neighborhood neighborhood) {
        return StreamSupport.stream(neighborhood.spliterator(), false);
    }

    private static boolean isCellWithPositiveValue(Cell cell) {
        return cell.getValue() > 0;
    }

    private static Stream<Cell> getAllNeighborsWithinDistanceStream(Neighborhood neighborhood, int  neighborDistance, Cell center) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(neighborhood.neighborIterator(center.getLocation(), neighborDistance), 0), false);
    }

    private static Cell countCell(Cell cell) {
        cell.incrementCount();
        return cell;
    }

    private static boolean isCellCountedOnlyOnce(Cell cell) {
        return cell.getTimesCounted() == 1;
    }

}
