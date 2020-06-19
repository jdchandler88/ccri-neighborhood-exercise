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
        int numberOfNeighbors = CellCounter.countUniqueCellsWithinDistanceOfActiveCells(neighborhood, neighborDistance);
        assertEquals(expectedNumberOfCells, numberOfNeighbors);
    }

    @MethodSource
    public static Stream<Arguments> exampleProblemTestDataProvider() {

        return Stream.of(
                //example 1: 11x11 array (H=11, W=11), N=3, +number at (5,5), 25 cells
                Arguments.of(
                        new NeighborhoodBuilder(11, 11)
                                .withValueAtLocation(new Location(5, 5), 1)
                                .build(),
                        3,
                        25),
                //example 2: 11x11 array (H=11, W=11), N=3, +number at (1,5), 21 cells
                Arguments.of(
                        new NeighborhoodBuilder(11, 11)
                                .withValueAtLocation(new Location(1, 5), 1)
                                .build(),
                        3,
                        21),
                //example 3: 11x11 array (H=11, W=11), N=2, +number at [(3,7), (7,3)], 26 cells
                Arguments.of(
                        new NeighborhoodBuilder(11, 11)
                                .withValueAtLocation(new Location(3, 7), 1)
                                .withValueAtLocation(new Location(7, 3), 1)
                                .build(),
                        2,
                        26
                ),
                //example 4: 11x11 array (H=11, W=11), N=2, +number at [(3,7), (5,6)], 22 cells
                Arguments.of(
                        new NeighborhoodBuilder(11, 11)
                                .withValueAtLocation(new Location(3, 7), 1)
                                .withValueAtLocation(new Location(5, 6), 1)
                                .build(),
                        2,
                        22
                ),
                //home-made example: 11x12 array (H=12, W=11), N=3, +numbers at [(8,0), (9,1), (10,2)]. this test multiple areas with 'fall-off' and potential multiple counts
                Arguments.of(
                        new NeighborhoodBuilder(11, 12)
                                .withValueAtLocation(new Location(8, 0), 1)
                                .withValueAtLocation(new Location(9, 1), 1)
                                .withValueAtLocation(new Location(10, 2), 1)
                                .build(),
                        3,
                        21
                ),
                //home-made example: 21x1; 15,0; N=4, 9 cells counted.  this tests a 1-row array with no roll-off
                Arguments.of(
                        new NeighborhoodBuilder(21, 1)
                                .withValueAtLocation(new Location(15, 0), 1)
                                .build(),
                        4,
                        9
                ),
                //home-made example: 21x1; 20,0; N=4, 5 cells counted. this tests a 1-row array with roll-off on the right side
                Arguments.of(
                        new NeighborhoodBuilder(21, 1)
                                .withValueAtLocation(new Location(20, 0), 1)
                                .build(),
                        4,
                        5
                ),
                //home-made example: 21x1; 0,0; N=4, 5 cells counted. this tests a 1-row array with roll-off on the left side
                Arguments.of(
                        new NeighborhoodBuilder(21, 1)
                                .withValueAtLocation(new Location(0, 0), 1)
                                .build(),
                        4,
                        5
                ),
                //home-made example: 1x21; (0,15); N=4; 9 cells counted. this tests a 1-column array with no roll-off
                Arguments.of(
                        new NeighborhoodBuilder(1,21)
                                .withValueAtLocation(new Location(0,15), 1)
                                .build(),
                        4,
                        9
                ),
                //home-made example: 1x21; (0,20); N=4; 5 cells counted. this tests a 1-row array with roll-off on the bottom
                Arguments.of(
                        new NeighborhoodBuilder(1,21)
                                .withValueAtLocation(new Location(0,20), 1)
                                .build(),
                        4,
                        5
                ),
                //home-made example: 1x21; (0,0); N=4; 5 cells counted. this tests a 1-row array with roll-off on the top
                Arguments.of(
                        new NeighborhoodBuilder(1,21)
                                .withValueAtLocation(new Location(0,0), 1)
                                .build(),
                        4,
                        5
                ),
                //home-made example: 9x9; [(0,0),(1,0),(0,1),(1,1)]; N=4; 26 cells counted. this tests
                //multiple values in the corner AND immediately adjacent
                Arguments.of(
                        new NeighborhoodBuilder(9,9)
                            .withValueAtLocation(new Location(0,0), 1)
                            .withValueAtLocation(new Location(1,0), 1)
                            .withValueAtLocation(new Location(0, 1), 1)
                            .withValueAtLocation(new Location(1, 1), 1)
                            .build(),
                        4,
                        26
                ),
                //home-made example: 5x5; [(0,0), (2,0), (4,0), (1,1), (3,1), (0,2), (2,2), (4,2), (1,3), (3,3), (0,4), (2,4), (4,4)], N=0, 13 cells counted
                //this tests a checkerboard pattern with N=0. the app should only count the positive cell values
                Arguments.of(
                        new NeighborhoodBuilder(5,5)
                            .withValueAtLocation(new Location(0,0),1)
                            .withValueAtLocation(new Location(2,0),1)
                            .withValueAtLocation(new Location(4,0),1)
                            .withValueAtLocation(new Location(1,1),1)
                            .withValueAtLocation(new Location(3,1),1)
                            .withValueAtLocation(new Location(0,2),1)
                            .withValueAtLocation(new Location(2,2),1)
                            .withValueAtLocation(new Location(4,2),1)
                            .withValueAtLocation(new Location(1,3),1)
                            .withValueAtLocation(new Location(3,3),1)
                            .withValueAtLocation(new Location(0,4),1)
                            .withValueAtLocation(new Location(2,4),1)
                            .withValueAtLocation(new Location(4,4),1)
                            .build(),
                        0,
                        13
                ),
                //home-made example: 5x5; (0,0); N=10000; 25 cells counted. this tests when N>>width && N>>height.
                //this should return the correct answer, but as written at this time, the algorithm is *NOT OPTIMIZED* at all
                    //NOTE: at the time of writing, this test takes a human-measureable amount of time (looong, about 3s)
                Arguments.of(
                        new NeighborhoodBuilder(5,5)
                            .withValueAtLocation(new Location(0, 0), 1)
                            .build(),
                        10000,
                        25
                )
        );
    }

}
