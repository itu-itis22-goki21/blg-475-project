package sonnet46.task65;

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
        assertEquals("001", s.circularShift(100, 2));
        assertEquals("12", s.circularShift(12, 2));
        assertEquals("79", s.circularShift(97, 8));
        assertEquals("21", s.circularShift(12, 1));
        assertEquals("11", s.circularShift(11, 101));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single digit — shift 0 (no shift)
        assertEquals("5", s.circularShift(5, 0));
        // Single digit — shift > digits returns reversed (same digit)
        assertEquals("5", s.circularShift(5, 2));
        // shift == number of digits → same as full rotation
        assertEquals("123", s.circularShift(123, 3));
        // shift exactly 1 for 3-digit number
        assertEquals("312", s.circularShift(123, 1));
    }
}
