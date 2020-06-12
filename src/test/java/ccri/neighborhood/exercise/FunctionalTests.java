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
    public void appShouldReturnAppropriateNumberOfCellsFromProblemExamples(int[][] neighborhood, int neighborDistance, int expectedNumberOfCells) {
        int numberOfNeighbors = CellCounter.count(neighborhood, neighborDistance);
        assertEquals(expectedNumberOfCells, numberOfNeighbors);
    }

    @MethodSource
    public static Stream<Arguments> exampleProblemTestDataProvider() {
        //example 1: 11x11 array (H=11, W=11), N=3, +number at (5,5), 25 cells
        int[][] neighborhood1 = createNeighborhoodOfSize(11, 11);
        insertNumberAtLocation(5,5,1, neighborhood1);
        Arguments argumentsForTest1 = createArgumentsForTest(neighborhood1, 3, 25);

        //example 2: 11x11 array (H=11, W=11), N=3, +number at (1,5), 21 cells
        int[][] neighborhood2 = createNeighborhoodOfSize(11, 11);
        insertNumberAtLocation(1,5,1, neighborhood2);
        Arguments argumentsForTest2 = createArgumentsForTest(neighborhood2, 3, 21);

        //example 3: 11x11 array (H=11, W=11), N=2, +number at [(3,7), (7,3)], 26 cells
        int[][] neighborhood3 = createNeighborhoodOfSize(11, 11);
        insertNumberAtLocation(3,7,1, neighborhood3);
        insertNumberAtLocation(7,3,1, neighborhood3);
        Arguments argumentsForTest3 = createArgumentsForTest(neighborhood3, 2, 26);

        //example 4: 11x11 array (H=11, W=11), N=2, +number at [(3,7), (5,6)], 22 cells
        int[][] neighborhood4 = createNeighborhoodOfSize(11, 11);
        insertNumberAtLocation(3,7,1, neighborhood4);
        insertNumberAtLocation(5,6,1, neighborhood4);
        Arguments argumentsForTest4 = createArgumentsForTest(neighborhood4, 2, 22);

        return Stream.of(argumentsForTest1, argumentsForTest2, argumentsForTest3, argumentsForTest4);
    }

    private static int[][] createNeighborhoodOfSize(int width, int height) {
        return new int[width][height];
    }

    private static void insertNumberAtLocation(int x, int y, int number, int[][] neighborhood) {
        neighborhood[x][y] = number;
    }

    private static Arguments createArgumentsForTest(int[][] neighborhood, int neighborDistance, int expectedNumberOfCells) {
        return Arguments.of(neighborhood, neighborDistance, expectedNumberOfCells);
    }

}
