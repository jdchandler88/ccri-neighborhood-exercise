package ccri.neighborhood.exercise;

import java.util.Iterator;
import java.util.stream.IntStream;

public class Neighborhood implements Iterable<Location> {

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
                this.neighborhood[x][y] = new Cell();
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
    public Iterator<Location> iterator() {
        return new NeighborhoodLocationIterator(
                this, new Location(0, 0));
    }

    public Iterator<Location> neighborIterator(Location centerLocation, int neighborThreshold) {
        return new NeighborLocationIterator(this, centerLocation, neighborThreshold);
    }

}
