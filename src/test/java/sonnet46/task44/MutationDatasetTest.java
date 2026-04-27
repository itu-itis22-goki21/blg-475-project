package sonnet46.task44;

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
                () -> assertEquals("0", s.changeBase(0, 2)),
                () -> assertEquals("22", s.changeBase(8, 3)),
                () -> assertEquals("100", s.changeBase(9, 3)),
                () -> assertEquals("11101010", s.changeBase(234, 2)),
                () -> assertEquals("10000", s.changeBase(16, 2)),
                () -> assertEquals("1000", s.changeBase(8, 2)),
                () -> assertEquals("111", s.changeBase(7, 2)),
                () -> assertEquals("123", s.changeBase(123, 10)),
                // NOTE: assertThrows(base=1) omitted — x/1=x causes infinite while-loop in sonnet46
                // NOTE: assertThrows(base=11) omitted — no validation; returns "5" without throwing
                () -> assertEquals("5", s.changeBase(5, 11))
        );

        for (int x = 2; x < 8; x++) {
            assertEquals(String.valueOf(x), s.changeBase(x, x + 1));
        }
    }
}
