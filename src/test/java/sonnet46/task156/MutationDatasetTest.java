package sonnet46.task156;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals("i", s.intToMiniRoman(1)),
                () -> assertEquals("iv", s.intToMiniRoman(4)),
                () -> assertEquals("ix", s.intToMiniRoman(9)),
                () -> assertEquals("xix", s.intToMiniRoman(19)),
                () -> assertEquals("xliii", s.intToMiniRoman(43)),
                () -> assertEquals("lviii", s.intToMiniRoman(58)),
                () -> assertEquals("xc", s.intToMiniRoman(90)),
                () -> assertEquals("xciv", s.intToMiniRoman(94)),
                () -> assertEquals("clii", s.intToMiniRoman(152)),
                () -> assertEquals("ccli", s.intToMiniRoman(251)),
                () -> assertEquals("cdxxvi", s.intToMiniRoman(426)),
                () -> assertEquals("d", s.intToMiniRoman(500)),
                () -> assertEquals("dxxxii", s.intToMiniRoman(532)),
                () -> assertEquals("cm", s.intToMiniRoman(900)),
                () -> assertEquals("cmxciv", s.intToMiniRoman(994)),
                () -> assertEquals("m", s.intToMiniRoman(1000)),
                // NOTE: sonnet46 has no range validation; 0 returns "" and 1001 returns "mi"
                () -> assertEquals("", s.intToMiniRoman(0)),
                () -> assertEquals("mi", s.intToMiniRoman(1001))
        );
    }
}
