package gpt54.task129;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void returnsOnlyOneWhenPathLengthIsOneAndOneIsInTheMiddle() {
        List<List<Integer>> grid = List.of(
                List.of(5, 9, 3),
                List.of(4, 1, 6),
                List.of(7, 8, 2)
        );

        assertEquals(List.of(1), solution.minPath(grid, 1));
    }

    @Test
    void alternatesBetweenTheTwoSmallestReachableValuesFromCorner() {
        List<List<Integer>> grid = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        assertEquals(List.of(1, 2, 1, 2, 1, 2), solution.minPath(grid, 6));
    }

    @Test
    void movesFromCenterToTheSmallestNeighborAndBack() {
        List<List<Integer>> grid = List.of(
                List.of(5, 9, 3),
                List.of(4, 1, 6),
                List.of(7, 8, 2)
        );

        assertEquals(List.of(1, 4, 1), solution.minPath(grid, 3));
    }

    @Test
    void handlesOneStartingInTheBottomRightCorner() {
        List<List<Integer>> grid = List.of(
                List.of(11, 8, 7, 2),
                List.of(5, 16, 14, 4),
                List.of(9, 3, 15, 6),
                List.of(12, 13, 10, 1)
        );

        assertEquals(List.of(1, 6, 1, 6), solution.minPath(grid, 4));
    }
}
