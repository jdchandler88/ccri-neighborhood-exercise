package ccri.neighborhood.exercise;

import java.util.ArrayList;

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

        //search for positive number
        for (int x = 0; x < width; x++) {
            for (int  y = 0; y < height; y++) {
                Location neighborhoodLocation = new Location(x, y);
                if (neighborhood.getValueAtLocation(neighborhoodLocation) > 0) {
                    //count number of neighbors within distance
                    for (int xSearch = (x-neighborDistance); xSearch <= x+neighborDistance; xSearch++) {
                        for (int ySearch = (y-neighborDistance); ySearch <= y+neighborDistance; ySearch++) {
                            Location neighborSearchLocation = new Location(xSearch, ySearch);
                            if (isWithinManhattanDistance(neighborhoodLocation, neighborSearchLocation, neighborDistance) && isWithinNeighborhoodBounds(neighborSearchLocation, width, height) && !isAlreadyCounted(neighborSearchLocation, counted)) {
                                count++;
                                counted[xSearch][ySearch] = true;
                            }
                        }
                    }

                }

            }
        }

        return count;
    }

    private static boolean isWithinManhattanDistance(Location location1, Location location2, int distance) {
        int xDist = Math.abs(location2.getX() - location1.getX());
        int yDist = Math.abs(location2.getY() - location1.getY());
        return xDist + yDist <= distance;
    }

    private static boolean isWithinNeighborhoodBounds(Location location, int width, int height) {
        int x = location.getX();
        int y = location.getY();
        return x >= 0 && x < width
            && y >= 0 && y < height;
    }

    private static boolean isAlreadyCounted(Location location, boolean[][] counted) {
        return counted[location.getX()][location.getY()];
    }

}
