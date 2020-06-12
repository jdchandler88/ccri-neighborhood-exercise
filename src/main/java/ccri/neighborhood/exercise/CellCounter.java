package ccri.neighborhood.exercise;

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
    public static int count(int[][] neighborhood, int neighborDistance) {

        int count = 0;

        //search for positive number
        for (int x = 0; x < neighborhood.length; x++) {
            for (int y = 0; y < neighborhood[0].length; y++) {

                if (neighborhood[x][y] > 0) {
                    //count number of neighbors within distance
                    for (int xSearch = (x-neighborDistance); xSearch <= x+neighborDistance; xSearch++) {
                        for (int ySearch = (y-neighborDistance); ySearch <= y+neighborDistance; ySearch++) {
                            if (isWithinManhattanDistance(x, y, xSearch, ySearch, neighborDistance)) {
                                count++;
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

}
