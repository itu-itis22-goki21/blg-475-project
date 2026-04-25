package gpt54.task76;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void returnsTrueWhenValueIsOne() {
        assertTrue(solution.isSimplePower(1, 4));
    }

    @Test
    void rejectsNonPositiveValues() {
        assertFalse(solution.isSimplePower(0, 2));
    }

    @Test
    void rejectsBasesLessThanOrEqualToOneForValuesGreaterThanOne() {
        assertFalse(solution.isSimplePower(3, 1));
    }

    @Test
    void acceptsExactPowers() {
        assertTrue(solution.isSimplePower(81, 3));
    }

    @Test
    void rejectsNumbersThatCannotBeReducedToOne() {
        assertFalse(solution.isSimplePower(12, 2));
    }
}
