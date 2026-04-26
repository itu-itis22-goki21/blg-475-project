package gpt54.task156;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
                () -> assertThrows(Throwable.class, () -> s.intToMiniRoman(0)),
                () -> assertThrows(Throwable.class, () -> s.intToMiniRoman(1001))
        );
    }
}
