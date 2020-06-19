package ccri.neighborhood.exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NeighborhoodTest {

    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "1, 10",
            "10, 1",
            "1,1"
    })
    public void shouldHaveARectangularShape(int width, int height) {
        Neighborhood neighborhood = new Neighborhood(width, height);
        assertEquals(width, neighborhood.neighborhood.length);
        Stream.of(neighborhood.neighborhood).forEach(row -> assertEquals(row.length, height));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 1",
            "1, -1",
            "0, 1",
            "1, 0"
    })
    public void shouldNotAllowZeroOrNegativeDimensions(int x, int y) {
        assertThrows(IllegalArgumentException.class, () -> new Neighborhood(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 0, 0, 1",
            "5, 5, 0, 0, -1",
            "5, 5, 4, 4, 1",
            "5, 5, 4, 4, -1",
            "1, 1, 0, 0, 1",
            "1, 1, 0, 0, -1",
    })
    public void shouldRetrieveSameValueAtLocationThatWasSet(int width, int height, int x, int y, int value) {
        Neighborhood neighborhood = new Neighborhood(width, height);
        Location testLocation = new Location(x, y);
        neighborhood.getCellAtLocation(testLocation).setValue(value);
        assertEquals(value, neighborhood.getCellAtLocation(testLocation).getValue());
    }

}
