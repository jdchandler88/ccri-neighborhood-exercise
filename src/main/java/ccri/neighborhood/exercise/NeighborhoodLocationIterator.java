package ccri.neighborhood.exercise;

import java.util.Iterator;

public class NeighborhoodLocationIterator implements Iterator<Location> {

    private Neighborhood neighborhood;
    private Location currentLocation;

    NeighborhoodLocationIterator(Neighborhood neighborhood, Location beginLocation) {
        this.neighborhood = neighborhood;
        this.currentLocation = beginLocation;
    }

    NeighborhoodLocationIterator(Neighborhood neighborhood) {
        this(neighborhood, new Location(0, 0));
    }

    @Override
    public boolean hasNext() {
        //if there are more row OR if there are more in this row
        int currentX = this.currentLocation.getX();
        int currentY = this.currentLocation.getY();
        return (currentY < neighborhood.getHeight() && currentX < neighborhood.getWidth());
    }

    @Override
    public Location next() {
        //get location for current iterator position
        Location location = this.currentLocation;
        //advance iterator
        if (isAtEndOfRow()) {
            moveIteratorToNextRow();
        } else {
            moveIteratorToNextColumnInRow();
        }
        return location;
    }

    private boolean isAtEndOfRow() {
        int currentX = this.currentLocation.getX();
        return currentX == neighborhood.getWidth() - 1;
    }

    private void moveIteratorToNextRow() {
        int nextX = 0;
        int nextY = this.currentLocation.getY() + 1;
        this.currentLocation = new Location(nextX, nextY);
    }

    private void moveIteratorToNextColumnInRow() {
        int nextX = this.currentLocation.getX() + 1;
        int nextY = this.currentLocation.getY();
        this.currentLocation = new Location(nextX, nextY);
    }

}
