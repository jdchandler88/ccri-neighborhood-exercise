package ccri.neighborhood.exercise;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class NeighborCellIteratorTest {

    /**
     *    **X**
     *    *XXX*
     *    XXXXX
     *    *XXX*
     *    **X**
     *
     *    13 iterations with 5x5 neighborhood at (2,2)
     */
    @Test
   public void shouldIterateAllNeighbors() {
       Neighborhood neighborhood = new NeighborhoodBuilder(5,5)
               .withValueAtLocation(new Location(2,2), 1)
               .build();

       Iterator<Cell> neighborIterator = neighborhood.neighborIterator(new Location(2,2), 2);

       int count = 0;
       while (neighborIterator.hasNext()) {
           Cell neighborCell = neighborIterator.next();
           count++;
       }

       assertEquals(13, count);

   }

}
