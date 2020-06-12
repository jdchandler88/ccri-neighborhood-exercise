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

                            //make sure that the cell is within manhattan distance
                            int xDist = Math.abs(xSearch - x);
                            int yDist = Math.abs(ySearch - y);

                            if (xDist + yDist <= neighborDistance) {
                                count++;
                            }
                        }
                    }

                }

            }
        }

        return count;
    }

}
