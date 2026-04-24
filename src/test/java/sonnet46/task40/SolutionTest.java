package sonnet46.task40;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertFalse(s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, 0))));
        assertFalse(s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, -1))));
        assertTrue(s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, -2, 1))));
        assertFalse(s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 2, 3, 7))));
        assertTrue(s.triplesSumToZero(new ArrayList<>(Arrays.asList(2, 4, -5, 3, 9, 7))));
        assertFalse(s.triplesSumToZero(new ArrayList<>(Arrays.asList(1))));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Exactly three elements summing to zero
        assertTrue(s.triplesSumToZero(new ArrayList<>(Arrays.asList(-1, 0, 1))));
        // Three elements not summing to zero
        assertFalse(s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 2, 3))));
        // All negatives — can't sum to zero with three distinct negatives
        assertFalse(s.triplesSumToZero(new ArrayList<>(Arrays.asList(-3, -2, -1))));
        // Large list with a zero triple
        assertTrue(s.triplesSumToZero(new ArrayList<>(Arrays.asList(5, 3, -8, 10, 2))));
    }
}
