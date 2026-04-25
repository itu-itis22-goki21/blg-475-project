package gpt54.task44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void returnsZeroStringForZeroInput() {
        assertEquals("0", solution.changeBase(0, 2));
    }

    @Test
    void convertsToBinary() {
        assertEquals("1000", solution.changeBase(8, 2));
    }

    @Test
    void convertsToBaseThree() {
        assertEquals("22", solution.changeBase(8, 3));
    }

    @Test
    void leavesSingleDigitValuesUnchangedWhenBaseIsLarger() {
        assertEquals("7", solution.changeBase(7, 8));
    }
}
