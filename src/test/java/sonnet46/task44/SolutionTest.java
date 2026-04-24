package sonnet46.task44;

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
        assertEquals("22", s.changeBase(8, 3));
        assertEquals("100", s.changeBase(9, 3));
        assertEquals("11101010", s.changeBase(234, 2));
        assertEquals("10000", s.changeBase(16, 2));
        assertEquals("1000", s.changeBase(8, 2));
        assertEquals("111", s.changeBase(7, 2));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // x == 0 branch
        assertEquals("0", s.changeBase(0, 2));
        assertEquals("0", s.changeBase(0, 8));
        // x = 1 in various bases
        assertEquals("1", s.changeBase(1, 2));
        assertEquals("1", s.changeBase(1, 9));
        // x equals base
        assertEquals("10", s.changeBase(3, 3));
    }
}
