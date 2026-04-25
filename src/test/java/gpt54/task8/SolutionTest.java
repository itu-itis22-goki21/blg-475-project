package gpt54.task8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void returnsIdentityValuesForEmptyList() {
        assertEquals(List.of(0, 1), solution.sumProduct(List.of()));
    }

    @Test
    void returnsSameNumberForSingleElementList() {
        assertEquals(List.of(10, 10), solution.sumProduct(List.of(10)));
    }

    @Test
    void returnsZeroProductWhenAnyElementIsZero() {
        assertEquals(List.of(100, 0), solution.sumProduct(List.of(100, 0)));
    }

    @Test
    void handlesMultiplePositiveNumbers() {
        assertEquals(List.of(15, 105), solution.sumProduct(List.of(3, 5, 7)));
    }

    @Test
    void handlesNegativeValues() {
        assertEquals(List.of(-2, -10), solution.sumProduct(List.of(-5, 1, 2)));
    }
}
