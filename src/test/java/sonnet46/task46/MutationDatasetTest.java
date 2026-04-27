package sonnet46.task46;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(0, s.fib4(0)),
                () -> assertEquals(0, s.fib4(1)),
                () -> assertEquals(2, s.fib4(2)),
                () -> assertEquals(0, s.fib4(3)),
                () -> assertEquals(2, s.fib4(4)),
                () -> assertEquals(4, s.fib4(5)),
                () -> assertEquals(28, s.fib4(8)),
                () -> assertEquals(104, s.fib4(10)),
                () -> assertEquals(386, s.fib4(12)),
                () -> assertEquals(fib4Expected(15), s.fib4(15)),
                () -> assertThrows(Throwable.class, () -> s.fib4(-1))
        );
    }

    private static int fib4Expected(int n) {
        int[] values = {0, 0, 2, 0, 2};
        if (n < values.length) {
            return values[n];
        }

        int[] dp = new int[n + 1];
        System.arraycopy(values, 0, dp, 0, values.length);
        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }
        return dp[n];
    }
}
