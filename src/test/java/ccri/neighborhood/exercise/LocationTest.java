package ccri.neighborhood.exercise;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LocationTest {

  @Test
  public void shouldReturnCoordinatesUsedToCreate() {
    Location loc = new Location(9, 99);
    assertAll(
        () -> assertEquals(9, loc.getX()),
        () -> assertEquals(99, loc.getY())
    );
  }

}
