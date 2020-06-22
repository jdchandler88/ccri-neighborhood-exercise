package ccri.neighborhood.exercise;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NeighborhoodIteratorTest {

  /**
   * This test assumes that the neighborhood is rectangular. The reason an iterator may be desirable
   * is multi-fold:
   * * the client can focus on what it wants to do with the locations, rather than traversing a
   * structure
   * * the structure of the neighborhood can change (irregular shapes, etc.) and the client should
   * still work as long as it has a functional iterator
   */
  @ParameterizedTest
  @CsvSource({
      "5,5",  //standard
      "1,1",   //single-cell
      "1,20", //one column, 20 rows
      "20,1"  //one row, 20 columns
  })
  public void shouldReturnEveryLocationOnlyOnce(int width, int height) {
    //could mock this. if we were to test with a very large neighborhood, then we'd probably want to
    // avoid allocating that memory
    //also, that would allow us to remove the builder and neighborhood implementation from this
    // test, focusing attention on the CUT
    Neighborhood neighborhood = new NeighborhoodBuilder(width, height).build();
    NeighborhoodIterator it = new NeighborhoodIterator(neighborhood);

    Set<Location> iteratedLocations = new HashSet<>();

    while (it.hasNext()) {
      Location location = it.next();
      if (!iteratedLocations
          .add(location)) {  //set returns false if the element already exists
        fail("Iterator has returned a duplicate location");
      }
    }

    assertEquals(width * height, iteratedLocations.size()); //width X height

  }

  @Test
  public void shouldAdvanceToNextRowWhenAtEndOfRow() {
    Neighborhood neighborhood = new NeighborhoodBuilder(5, 5).build();
    NeighborhoodIterator it = new NeighborhoodIterator(
        neighborhood,
        new Location(4, 0)
    );
    Location currentLocation = it.next();   //put iterator initially at end of row. this will get
    // the location and then advance the iterator
    Location nextLocation = it.next();  //the iterator, having advanced, should be at the next row
    assertAll(
        () -> assertEquals(new Location(4, 0), currentLocation),
        () -> assertEquals(new Location(0, 1), nextLocation)
    );
  }

  @Test
  public void shouldNotHaveAnyMoreLocationsWhenAtEndOfNeighborhood() {
    Neighborhood neighborhood = new NeighborhoodBuilder(5, 5).build();
    NeighborhoodIterator it = new NeighborhoodIterator(
        neighborhood,
        new Location(4, 4)
    );
    Location currentLocation = it.next(); //"consume" the last location in the neighborhood,
    // advancing the iterator.
    assertAll(
        () -> assertEquals(new Location(4, 4), currentLocation),
        () -> assertFalse(it.hasNext())
    );
  }

}
