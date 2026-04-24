package sonnet46.task55;

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
        assertEquals(55, s.fib(10));
        assertEquals(1, s.fib(1));
        assertEquals(21, s.fib(8));
        assertEquals(89, s.fib(11));
        assertEquals(144, s.fib(12));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // n == 0 branch
        assertEquals(0, s.fib(0));
        // n == 1 branch
        assertEquals(1, s.fib(1));
        // n == 2 (first computed)
        assertEquals(1, s.fib(2));
        assertEquals(2, s.fib(3));
    }
}
