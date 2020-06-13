package ccri.neighborhood.exercise;

public class Neighborhood {

    private static final String NEIGHBORHOOD_DIMENSION_VALIDATION_ERROR_MESSAGE_TEMPLATE = "Neighborhood width and height must each be > 0. Received width=%d";

    int width;

    int height;

    int[][] neighborhood;

    public Neighborhood(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(String.format(NEIGHBORHOOD_DIMENSION_VALIDATION_ERROR_MESSAGE_TEMPLATE, width, height));
        }
        this.width = width;
        this.height = height;
        this.neighborhood = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setValueAtLocation(int x, int y, int value) {
        this.neighborhood[x][y] = value;
    }

    public int getValueAtLocation(int x, int y) {
        return this.neighborhood[x][y];
    }

}
