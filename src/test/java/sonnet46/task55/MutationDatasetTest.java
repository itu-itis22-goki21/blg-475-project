package sonnet46.task55;

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
                () -> assertEquals(1, s.fib(1)),
                () -> assertEquals(1, s.fib(2)),
                () -> assertEquals(2, s.fib(3)),
                () -> assertEquals(21, s.fib(8)),
                () -> assertEquals(55, s.fib(10)),
                () -> assertEquals(89, s.fib(11)),
                () -> assertEquals(144, s.fib(12)),
                () -> assertEquals(6765, s.fib(20)),
                // NOTE: sonnet46 fib(0) returns 0 (explicit base case); no throw
                () -> assertEquals(0, s.fib(0)),
                // NOTE: sonnet46 fib(-1) returns 1: iterative loop for(i=2;i<=-1) skips,
                //       leaving curr=1 as the initial value
                () -> assertEquals(1, s.fib(-1))
        );
    }
}
