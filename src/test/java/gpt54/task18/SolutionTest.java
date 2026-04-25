package gpt54.task18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void returnsZeroForEmptySubstring() {
        assertEquals(0, solution.howManyTimes("abc", ""));
    }

    @Test
    void returnsZeroWhenSubstringIsLongerThanString() {
        assertEquals(0, solution.howManyTimes("ab", "abc"));
    }

    @Test
    void countsOverlappingMatches() {
        assertEquals(3, solution.howManyTimes("aaaa", "aa"));
    }

    @Test
    void countsSeparatedOccurrences() {
        assertEquals(2, solution.howManyTimes("banana", "ana"));
    }
}
