package ccri.neighborhood.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NeighborhoodTest {

  /**
   * Verifies that the neighborhood has the correct shape. The neighborhood should be rectangular
   * with each row having the same number of columns
   * @param width width of the neighborhood to be created
   * @param height height of the neighborhood to be created
   */
  @ParameterizedTest
  @CsvSource({
      "5, 5",
      "1, 10",
      "10, 1",
      "1,1"
  })
  public void shouldHaveARectangularShape(int width, int height) {
    Neighborhood neighborhood = new Neighborhood(width, height);
    assertEquals(width, neighborhood.neighborhoodArray.length);
    Stream.of(neighborhood.neighborhoodArray).forEach(row -> assertEquals(row.length, height));
  }

  /**
   * Verifies that the neighborhood does not allow creation with nonsensical dimensions.
   * @param width width of the neighborhood to be created
   * @param height height of the neighborhood to be created
   */
  @ParameterizedTest
  @CsvSource({
      "-1, 1",
      "1, -1",
      "0, 1",
      "1, 0"
  })
  public void shouldNotAllowZeroOrNegativeDimensions(int width, int height) {
    assertThrows(IllegalArgumentException.class, () -> new Neighborhood(width, height));
  }

  /**
   * Verifies that the neighborhood stores the value at the location and that the value retrieved
   * is the same.
   * @param width width of the neighborhood to be created
   * @param height height of the neighborhood to be created
   * @param x x-location of the value to set
   * @param y y-location of the value to set
   * @param value the value to set at the specified location
   */
  @ParameterizedTest
  @CsvSource({
      "5, 5, 0, 0, 1",
      "5, 5, 0, 0, -1",
      "5, 5, 4, 4, 1",
      "5, 5, 4, 4, -1",
      "1, 1, 0, 0, 1",
      "1, 1, 0, 0, -1",
  })
  public void shouldRetrieveSameValueAtLocationThatWasSet(int width, int height, int x, int y,
                                                          int value) {
    Neighborhood neighborhood = new Neighborhood(width, height);
    Location testLocation = new Location(x, y);
    neighborhood.getCellAtLocation(testLocation).setValue(value);
    assertEquals(value, neighborhood.getCellAtLocation(testLocation).getValue());
  }

}
