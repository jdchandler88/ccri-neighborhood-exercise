package ccri.neighborhood.exercise;

import java.util.Iterator;

public class Neighborhood implements Iterable<Cell> {

    private static final String NEIGHBORHOOD_DIMENSION_VALIDATION_ERROR_MESSAGE_TEMPLATE = "Neighborhood width and height must each be > 0. Received width=%d";

    int width;

    int height;

    Cell[][] neighborhood;

    public Neighborhood(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(String.format(NEIGHBORHOOD_DIMENSION_VALIDATION_ERROR_MESSAGE_TEMPLATE, width, height));
        }
        this.width = width;
        this.height = height;
        this.neighborhood = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.neighborhood[x][y] = new Cell(new Location(x, y));
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCellAtLocation(Location location) {
        return this.neighborhood[location.getX()][location.getY()];
    }

    @Override
    public Iterator<Cell> iterator() {
        return new NeighborhoodCellIterator(
                this, new Location(0, 0));
    }

    public Iterator<Cell> neighborIterator(Location centerLocation, int neighborThreshold) {
        return new NeighborCellIterator(this, centerLocation, neighborThreshold);
    }

}
