package sonnet46.task18;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertEquals(0, s.howManyTimes("", "x"));
        assertEquals(4, s.howManyTimes("xyxyxyx", "x"));
        assertEquals(4, s.howManyTimes("cacacacac", "cac"));
        assertEquals(1, s.howManyTimes("john doe", "john"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Empty substring guard branch
        assertEquals(0, s.howManyTimes("hello", ""));
        // Substring longer than string
        assertEquals(0, s.howManyTimes("ab", "abc"));
        // No match
        assertEquals(0, s.howManyTimes("hello", "xyz"));
        // Overlapping match
        assertEquals(3, s.howManyTimes("aaaa", "aa"));
    }
}
