package ccri.neighborhood.exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeighborhoodBuilderTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 3",
            "3, 2"
    })
    public void shouldCreateNeighborhoodOfSpecifiedSize(int width, int height) {
        Neighborhood neighborhood = new NeighborhoodBuilder(width, height).build();
        assertAll(
                () -> assertEquals(width, neighborhood.getWidth()),
                () -> assertEquals(height, neighborhood.getHeight())
        );
    }

    public void shouldCreateNeighborhoodWithValuesAtExpectedPlaces() {
        NeighborhoodBuilder builder =
                new NeighborhoodBuilder(5, 5)
                .withValueAtLocation(new Location(0,0), 1)
                .withValueAtLocation(new Location(1,1),1)
                .withValueAtLocation(new Location(2,2),1)
                .withValueAtLocation(new Location(3,3),1)
                .withValueAtLocation(new Location(4,4),1);
        Neighborhood neighborhood = builder.build();
        assertAll(
                () -> assertEquals(1, neighborhood.getValueAtLocation(new Location(0, 0))),
                () -> assertEquals(1, neighborhood.getValueAtLocation(new Location(1,1))),
                () -> assertEquals(1, neighborhood.getValueAtLocation(new Location(2,2))),
                () -> assertEquals(1, neighborhood.getValueAtLocation(new Location(3,3))),
                () -> assertEquals(1, neighborhood.getValueAtLocation(new Location(4,4)))
        );
    }

}
