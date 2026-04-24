package sonnet46.task156;

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
        assertEquals("xix", s.intToMiniRoman(19));
        assertEquals("clii", s.intToMiniRoman(152));
        assertEquals("ccli", s.intToMiniRoman(251));
        assertEquals("cdxxvi", s.intToMiniRoman(426));
        assertEquals("d", s.intToMiniRoman(500));
        assertEquals("i", s.intToMiniRoman(1));
        assertEquals("iv", s.intToMiniRoman(4));
        assertEquals("xliii", s.intToMiniRoman(43));
        assertEquals("xc", s.intToMiniRoman(90));
        assertEquals("xciv", s.intToMiniRoman(94));
        assertEquals("cm", s.intToMiniRoman(900));
        assertEquals("m", s.intToMiniRoman(1000));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Subtractive pairs
        assertEquals("ix", s.intToMiniRoman(9));
        assertEquals("xl", s.intToMiniRoman(40));
        assertEquals("cd", s.intToMiniRoman(400));
        assertEquals("cmxcix", s.intToMiniRoman(999));
        // Lowercase check — critical on Turkish locale
        assertEquals("xix", s.intToMiniRoman(19));
        assertEquals("clii", s.intToMiniRoman(152));
    }
}
