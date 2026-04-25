package gpt54.task0;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void returnsFalseWhenListHasFewerThanTwoElements() {
        assertFalse(solution.hasCloseElements(List.of(1.0), 0.5));
    }

    @Test
    void findsCloseValuesAfterSorting() {
        assertTrue(solution.hasCloseElements(List.of(11.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.3));
    }

    @Test
    void returnsFalseWhenClosestDistanceEqualsThreshold() {
        assertFalse(solution.hasCloseElements(List.of(1.0, 2.0, 3.0), 1.0));
    }

    @Test
    void treatsDuplicateValuesAsCloseElements() {
        assertTrue(solution.hasCloseElements(List.of(1.0, 2.0, 2.0, 4.0), 0.1));
    }
}
