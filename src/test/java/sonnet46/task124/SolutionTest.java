package sonnet46.task124;

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
        assertTrue(s.validDate("03-11-2000"));
        assertFalse(s.validDate("15-01-2012"));
        assertFalse(s.validDate("04-0-2040"));
        assertTrue(s.validDate("06-04-2020"));
        assertTrue(s.validDate("01-01-2007"));
        assertFalse(s.validDate("03-32-2011"));
        assertFalse(s.validDate(""));
        assertFalse(s.validDate("04-31-3000"));
        assertTrue(s.validDate("06-06-2005"));
        assertFalse(s.validDate("21-31-2000"));
        assertTrue(s.validDate("04-12-2003"));
        assertFalse(s.validDate("04122003"));
        assertFalse(s.validDate("2003-04-12"));
        assertFalse(s.validDate("2003-04"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Month part wrong length (1 digit)
        assertFalse(s.validDate("3-11-2000"));
        // Day part wrong length (1 digit)
        assertFalse(s.validDate("03-1-2000"));
        // Year part wrong length (2 digits)
        assertFalse(s.validDate("03-11-00"));
        // February 30 is invalid
        assertFalse(s.validDate("02-30-2000"));
        // February 29 is allowed
        assertTrue(s.validDate("02-29-2000"));
        // Day 0 is invalid
        assertFalse(s.validDate("01-00-2020"));
        // Month 0 is invalid
        assertFalse(s.validDate("00-01-2020"));
        // null input: hits the date == null TRUE branch of the null || isEmpty() guard
        assertFalse(s.validDate(null));
    }
}
