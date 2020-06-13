package ccri.neighborhood.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains test cases for the examples provided in the problem. These
 * test cases are not exhaustive, but are the bare minimum to show capability.
 */
public class FunctionalTests {

    @ParameterizedTest(name = "[{index} Expects {2} cells]")
    @MethodSource("exampleProblemTestDataProvider")
    public void appShouldReturnAppropriateNumberOfCellsFromProblemExamples(Neighborhood neighborhood, int neighborDistance, int expectedNumberOfCells) {
        int numberOfNeighbors = CellCounter.count(neighborhood, neighborDistance);
        assertEquals(expectedNumberOfCells, numberOfNeighbors);
    }

    @MethodSource
    public static Stream<Arguments> exampleProblemTestDataProvider() {
        //example 1: 11x11 array (H=11, W=11), N=3, +number at (5,5), 25 cells
        Neighborhood neighborhood1 = new Neighborhood(11, 11);
        neighborhood1.setValueAtLocation(5, 5, 1);
        Arguments argumentsForTest1 = createArgumentsForTest(neighborhood1, 3, 25);

        //example 2: 11x11 array (H=11, W=11), N=3, +number at (1,5), 21 cells
        Neighborhood neighborhood2 = new Neighborhood(11, 11);
        neighborhood2.setValueAtLocation(1,5,1);
        Arguments argumentsForTest2 = createArgumentsForTest(neighborhood2, 3, 21);

        //example 3: 11x11 array (H=11, W=11), N=2, +number at [(3,7), (7,3)], 26 cells
        Neighborhood neighborhood3 = new Neighborhood(11, 11);
        neighborhood3.setValueAtLocation(3,7,1);
        neighborhood3.setValueAtLocation(7,3,1);
        Arguments argumentsForTest3 = createArgumentsForTest(neighborhood3, 2, 26);

        //example 4: 11x11 array (H=11, W=11), N=2, +number at [(3,7), (5,6)], 22 cells
        Neighborhood neighborhood4 = new Neighborhood(11, 11);
        neighborhood4.setValueAtLocation(3,7,1);
        neighborhood4.setValueAtLocation(5,6,1);
        Arguments argumentsForTest4 = createArgumentsForTest(neighborhood4, 2, 22);

        return Stream.of(argumentsForTest1, argumentsForTest2, argumentsForTest3, argumentsForTest4);
    }

    private static Arguments createArgumentsForTest(Neighborhood neighborhood, int neighborDistance, int expectedNumberOfCells) {
        return Arguments.of(neighborhood, neighborDistance, expectedNumberOfCells);
    }

}
