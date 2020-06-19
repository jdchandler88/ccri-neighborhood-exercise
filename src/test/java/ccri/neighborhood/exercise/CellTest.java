package ccri.neighborhood.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    private static Location dummyLocation = new Location(0, 0);

    @Test
    public void shouldReturnZeroAsDefaultValue() {
        assertEquals(0, new Cell(dummyLocation).getValue());
    }

    @Test
    public void shouldReturnLocationThatWasSet() {
        Cell cell = new Cell(dummyLocation);
        cell.setValue(3);
        assertEquals(3, cell.getValue());
    }

    @Test
    public void shouldInitiallyReturnZeroCount() {
        assertEquals(0, new Cell(dummyLocation).getTimesCounted());
    }

    @Test
    public void shouldIncrementCount() {
        Cell cell = new Cell(dummyLocation);
        cell.incrementCount();
        assertEquals(1, cell.getTimesCounted());
    }

    @Test
    public void shouldReturnLocationItWasCreatedWith() {
        Location location = new Location(33, 44);
        Cell cell = new Cell(location);
        assertEquals(location, cell.getLocation());
    }

}
