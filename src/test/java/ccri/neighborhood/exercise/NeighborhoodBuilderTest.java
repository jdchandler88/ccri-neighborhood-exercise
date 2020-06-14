package ccri.neighborhood.exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeighborhoodBuilderTest {

    /*
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
    */

}
