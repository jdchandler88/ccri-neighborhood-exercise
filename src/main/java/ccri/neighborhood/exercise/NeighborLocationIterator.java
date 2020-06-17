package ccri.neighborhood.exercise;

import java.util.Iterator;

public class NeighborLocationIterator implements Iterator<Location> {

    private Neighborhood neighborhood;

    private Location centerLocation;

    int neighborThreshold;

    int currentX;

    int currentY;

    public NeighborLocationIterator(Neighborhood neighborhood, Location centerLocation, int neighborThreshold) {
        this.neighborhood = neighborhood;
        this.centerLocation = centerLocation;
        this.neighborThreshold = neighborThreshold;
        this.currentX = centerLocation.getX() - neighborThreshold;
        this.currentY = centerLocation.getY() - neighborThreshold;
    }

    @Override
    public boolean hasNext() {
        while (hasMorePossibleNeighbors()) {
            Location currentLocation = new Location(this.currentX, this.currentY);
            if (isValidNeighborLocation(currentLocation)) {
                return true;
            } else {
                advanceCursor();
            }
        }
        return false;
    }

    @Override
    public Location next() {
        Location location = new Location(currentX, currentY);
        advanceCursor();
        return location;
    }

    private boolean hasMorePossibleNeighbors() {
        return currentX <= (centerLocation.getX() + neighborThreshold) && currentY <= (centerLocation.getY() + neighborThreshold);
    }

    private boolean isValidNeighborLocation(Location location) {
        return isWithinManhattanDistanceFromCenterLocation(location) && isWithinNeighborhoodBounds(location);
    }

    private void advanceCursor() {
        if (isAtEndOfCurrentRow()) {
            moveCursorToNextRow();
        } else {
            moveCursorToNextColumn();
        }
    }

    private boolean isAtEndOfCurrentRow() {
        return currentX == centerLocation.getX() + neighborThreshold;
    }

    private void moveCursorToNextRow() {
        currentX = this.centerLocation.getX() - this.neighborThreshold;
        currentY++;
    }

    private void moveCursorToNextColumn() {
        currentX++;
    }

    private boolean isWithinManhattanDistanceFromCenterLocation(Location location) {
        int xDist = Math.abs(centerLocation.getX() - location.getX());
        int yDist = Math.abs(centerLocation.getY() - location.getY());
        return xDist + yDist <= neighborThreshold;
    }

    private boolean isWithinNeighborhoodBounds(Location location) {
        int x = location.getX();
        int y = location.getY();
        return x >= 0 && x < neighborhood.getWidth()
                && y >= 0 && y < neighborhood.getHeight();
    }

}
