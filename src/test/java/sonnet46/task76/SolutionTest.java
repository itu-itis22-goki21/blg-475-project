package sonnet46.task76;

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
        assertTrue(s.isSimplePower(1, 4));
        assertTrue(s.isSimplePower(2, 2));
        assertTrue(s.isSimplePower(8, 2));
        assertFalse(s.isSimplePower(3, 2));
        assertFalse(s.isSimplePower(3, 1));
        assertFalse(s.isSimplePower(5, 3));
        assertTrue(s.isSimplePower(16, 2));
        assertTrue(s.isSimplePower(4, 2));
        assertTrue(s.isSimplePower(9, 3));
        assertTrue(s.isSimplePower(16, 4));
        assertFalse(s.isSimplePower(24, 2));
        assertTrue(s.isSimplePower(1, 1));
        assertTrue(s.isSimplePower(1, 12));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // n == 1 branch: only x == 1 returns true
        assertTrue(s.isSimplePower(1, 1));
        assertFalse(s.isSimplePower(2, 1));
        assertFalse(s.isSimplePower(5, 1));
        // Power of 3
        assertTrue(s.isSimplePower(27, 3));
        assertFalse(s.isSimplePower(26, 3));
    }
}
