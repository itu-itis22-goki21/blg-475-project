package sonnet46.task13;

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
        assertEquals(1, s.greatestCommonDivisor(3, 7));
        assertEquals(5, s.greatestCommonDivisor(10, 15));
        assertEquals(7, s.greatestCommonDivisor(49, 14));
        assertEquals(12, s.greatestCommonDivisor(144, 60));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // GCD with itself
        assertEquals(5, s.greatestCommonDivisor(5, 5));
        // GCD with 1 — gcd(n, 1) is always 1
        assertEquals(1, s.greatestCommonDivisor(7, 1));
        // GCD of coprime numbers
        assertEquals(1, s.greatestCommonDivisor(17, 13));
        // GCD where one divides the other
        assertEquals(6, s.greatestCommonDivisor(6, 12));
    }
}
