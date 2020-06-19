package ccri.neighborhood.exercise;

public class Cell {

    private int value = 0;

    private int timesCounted = 0;

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
