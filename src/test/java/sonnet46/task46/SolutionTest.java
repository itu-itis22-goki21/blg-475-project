package sonnet46.task46;

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
        assertEquals(4, s.fib4(5));
        assertEquals(28, s.fib4(8));
        assertEquals(104, s.fib4(10));
        assertEquals(386, s.fib4(12));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Base cases — covers n < 4 branch
        assertEquals(0, s.fib4(0));
        assertEquals(0, s.fib4(1));
        assertEquals(2, s.fib4(2));
        assertEquals(0, s.fib4(3));
        // First computed value
        assertEquals(2, s.fib4(4));
    }
}
