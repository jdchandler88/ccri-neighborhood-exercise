package ccri.neighborhood.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import org.junit.jupiter.api.Test;

public class NeighborIteratorTest {

  /**
   * Verifies that a cell with a positive value within a 5x5 neighborhood returns the correct number
   * of cells. The iterated cells are expected as follows:
   * **X**
   * *XXX*
   * XXXXX
   * *XXX*
   * **X**
   * This setup should yield 13 iterations.
   */
  @Test
  public void shouldIterateAllNeighbors() {
    Neighborhood neighborhood = new NeighborhoodBuilder(5, 5)
        .withValueAtLocation(new Location(2, 2), 1)
        .build();

    Iterator<Location> neighborIterator = neighborhood.neighborIterator(new Location(2, 2), 2);

    int count = 0;
    while (neighborIterator.hasNext()) {
      neighborIterator.next();
      count++;
    }

    assertEquals(13, count);

  }

}
