package ccri.neighborhood.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    @Test
    public void shouldReturnZeroAsDefaultValue() {
        assertEquals(0, new Cell().getValue());
    }

    @Test
    public void shouldReturnLocationThatWasSet() {
        Cell cell = new Cell();
        cell.setValue(3);
        assertEquals(3, cell.getValue());
    }

    @Test
    public void shouldInitiallyReturnZeroCount() {
        assertEquals(0, new Cell().getTimesCounted());
    }

    @Test
    public void shouldIncrementCount() {
        Cell cell = new Cell();
        cell.incrementCount();
        assertEquals(1, cell.getTimesCounted());
    }

}
