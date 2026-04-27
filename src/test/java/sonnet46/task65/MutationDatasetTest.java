package sonnet46.task65;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals("7", s.circularShift(7, 100)),
                () -> assertEquals("1234", s.circularShift(1234, 0)),
                () -> assertEquals("001", s.circularShift(100, 2)),
                () -> assertEquals("12", s.circularShift(12, 2)),
                () -> assertEquals("79", s.circularShift(97, 8)),
                () -> assertEquals("21", s.circularShift(12, 1)),
                () -> assertEquals("11", s.circularShift(11, 101)),
                () -> invokeWithBadShift(s)
        );
    }

    private static void invokeWithBadShift(Solution s) throws Exception {
        Method method = Solution.class.getDeclaredMethod("circularShift", int.class, int.class);
        assertThrows(IllegalArgumentException.class, () -> method.invoke(s, 12, "bad"));
    }
}
