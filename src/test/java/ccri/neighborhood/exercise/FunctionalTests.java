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

        //home-made example: 11x12 array (H=12, W=11), N=3, +numbers at [(8,0), (9,1), (10,2)]. this test multiple areas with 'fall-off' and potential multiple counts
        Neighborhood neighborhood5 = new Neighborhood(11, 12);
        neighborhood5.setValueAtLocation(8, 0, 1);
        neighborhood5.setValueAtLocation(9, 1, 1);
        neighborhood5.setValueAtLocation(10, 2, 1);
        Arguments argumentsForTest5 = createArgumentsForTest(neighborhood5, 3, 21);

        //home-made example: 21x1; 15,0; N=4, 9 cells counted.  this tests a 1-row array with no roll-off
        Neighborhood neighborhood6 = new Neighborhood(21, 1);
        neighborhood6.setValueAtLocation(15, 0, 1);
        Arguments argumentsForTest6 = createArgumentsForTest(neighborhood6, 4, 9);

        //home-made example: 21x1; 20,0; N=4, 5 cells counted. this tests a 1-row array with roll-off on the right side
        Neighborhood neighborhood7 = new Neighborhood(21, 1);
        neighborhood7.setValueAtLocation(20, 0, 1);
        Arguments argumentsForTest7 = createArgumentsForTest(neighborhood7, 4, 5);

        //home-made example: 21x1; 0,0; N=4, 5 cells counted. this tests a 1-row array with roll-off on the left side
        Neighborhood neighborhood8 = new Neighborhood(21, 1);
        neighborhood8.setValueAtLocation(0, 0, 1);
        Arguments argumentsForTest8 = createArgumentsForTest(neighborhood8, 4, 5);

        return Stream.of(argumentsForTest1, argumentsForTest2, argumentsForTest3, argumentsForTest4, argumentsForTest5,
                argumentsForTest6, argumentsForTest7, argumentsForTest8);
    }

    private static Arguments createArgumentsForTest(Neighborhood neighborhood, int neighborDistance, int expectedNumberOfCells) {
        return Arguments.of(neighborhood, neighborDistance, expectedNumberOfCells);
    }

}
