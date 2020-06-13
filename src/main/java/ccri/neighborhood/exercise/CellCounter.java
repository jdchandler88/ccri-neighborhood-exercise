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
            for (int y = 0; y < height; y++) {

                if (neighborhood.getValueAtLocation(x, y) > 0) {
                    //count number of neighbors within distance
                    for (int xSearch = (x-neighborDistance); xSearch <= x+neighborDistance; xSearch++) {
                        for (int ySearch = (y-neighborDistance); ySearch <= y+neighborDistance; ySearch++) {
                            if (isWithinManhattanDistance(x, y, xSearch, ySearch, neighborDistance) && isWithinNeighborhoodBounds(xSearch, ySearch, width, height) && !isAlreadyCounted(xSearch, ySearch, counted)) {
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

    private static boolean isWithinManhattanDistance(int x1, int y1, int x2, int y2, int distance) {
        int xDist = Math.abs(x2 - x1);
        int yDist = Math.abs(y2 - y1);
        return xDist + yDist <= distance;
    }

    private static boolean isWithinNeighborhoodBounds(int x, int y, int width, int height) {
        return x >= 0 && x < width
            && y >= 0 && y < height;
    }

    private static boolean isAlreadyCounted(int x, int y, boolean[][] counted) {
        return counted[x][y];
    }

}
