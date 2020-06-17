package ccri.neighborhood.exercise;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class counts the number of neighbors within a specified distance of cells containing a positive number.
 */
public final class CellCounter {

    /**
     * Prevent instantiation
     */
    private CellCounter() {}

    /**
     * Count the number of neighbors within 'neighborDistance' cells of a positive value.
     * @param neighborhood neighborhood of cells
     * @param neighborDistance distance (manhattan) from cell with positive value to count neighbors
     * @return number of neighbors within 'neighborDistance' of cells with positive value
     */
    public static int count(Neighborhood neighborhood, int neighborDistance) {

        int width = neighborhood.getWidth();
        int height = neighborhood.getHeight();

        boolean[][] counted = new boolean[width][height];

        int count = 0;

        for (Location neighborhoodLocation : neighborhood) {
            if (neighborhood.getValueAtLocation(neighborhoodLocation) > 0) {
                //count number of neighbors within distance
                Iterator<Location> neighborIterator = neighborhood.neighborIterator(neighborhoodLocation, neighborDistance);
                while (neighborIterator.hasNext()) {
                    Location neighborLocation = neighborIterator.next();
                    if (!isAlreadyCounted(neighborLocation, counted)) {
                        count++;
                        counted[neighborLocation.getX()][neighborLocation.getY()] = true;
                    }
                }
            }
        }
        return count;
    }

    private static boolean isAlreadyCounted(Location location, boolean[][] counted) {
        return counted[location.getX()][location.getY()];
    }

}
