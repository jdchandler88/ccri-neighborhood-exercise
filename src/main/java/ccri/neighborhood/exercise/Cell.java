package ccri.neighborhood.exercise;

public class Cell {

    private Location location;

    private int value = 0;

    private int timesCounted = 0;

    public Cell(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void incrementCount() {
        timesCounted++;
    }

    public int getTimesCounted() {
        return timesCounted;
    }

}
