package sonnet46.task13;

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
                () -> assertEquals(1, s.greatestCommonDivisor(3, 7)),
                () -> assertEquals(5, s.greatestCommonDivisor(10, 15)),
                () -> assertEquals(7, s.greatestCommonDivisor(49, 14)),
                () -> assertEquals(12, s.greatestCommonDivisor(144, 60)),
                () -> assertEquals(6, s.greatestCommonDivisor(6, 6)),
                () -> assertEquals(8, s.greatestCommonDivisor(8, 24)),
                () -> assertEquals(8, s.greatestCommonDivisor(24, 8)),
                () -> assertEquals(9, s.greatestCommonDivisor(0, 9)),
                () -> assertEquals(9, s.greatestCommonDivisor(9, 0)),
                () -> assertEquals(6, s.greatestCommonDivisor(-54, 24)),
                () -> assertEquals(6, s.greatestCommonDivisor(54, -24)),
                () -> assertEquals(6, s.greatestCommonDivisor(-54, -24)),
                // NOTE: gcd(0,0) returns 0 in sonnet46 (Euclidean loop: b=0 from start, returns Math.abs(0)=0)
                () -> assertEquals(0, s.greatestCommonDivisor(0, 0))
        );
    }
}
