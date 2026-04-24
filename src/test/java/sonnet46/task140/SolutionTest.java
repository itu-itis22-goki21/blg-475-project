package sonnet46.task140;

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
        assertEquals("Example", s.fixSpaces("Example"));
        assertEquals("Mudasir_Hanif_", s.fixSpaces("Mudasir Hanif "));
        assertEquals("Yellow_Yellow__Dirty__Fellow", s.fixSpaces("Yellow Yellow  Dirty  Fellow"));
        assertEquals("Exa-mple", s.fixSpaces("Exa   mple"));
        assertEquals("-Exa_1_2_2_mple", s.fixSpaces("   Exa 1 2 2 mple"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // No spaces at all
        assertEquals("NoSpaces", s.fixSpaces("NoSpaces"));
        // Exactly 2 consecutive spaces → 2 underscores
        assertEquals("a__b", s.fixSpaces("a  b"));
        // Exactly 3 consecutive spaces → dash
        assertEquals("a-b", s.fixSpaces("a   b"));
        // Empty string
        assertEquals("", s.fixSpaces(""));
        // Single space
        assertEquals("_", s.fixSpaces(" "));
    }
}
