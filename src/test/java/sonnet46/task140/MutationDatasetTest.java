package sonnet46.task140;

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
                () -> assertEquals("", s.fixSpaces("")),
                () -> assertEquals("Example", s.fixSpaces("Example")),
                () -> assertEquals("a_b", s.fixSpaces("a b")),
                () -> assertEquals("One_Two", s.fixSpaces("One Two")),
                () -> assertEquals("Mudasir_Hanif_", s.fixSpaces("Mudasir Hanif ")),
                () -> assertEquals("Yellow_Yellow__Dirty__Fellow", s.fixSpaces("Yellow Yellow  Dirty  Fellow")),
                () -> assertEquals("Exa-mple", s.fixSpaces("Exa   mple")),
                () -> assertEquals("-Exa_1_2_2_mple", s.fixSpaces("   Exa 1 2 2 mple")),
                () -> invokeWithBadArgument(s)
        );
    }

    private static void invokeWithBadArgument(Solution s) throws Exception {
        Method method = Solution.class.getDeclaredMethod("fixSpaces", String.class);
        assertThrows(IllegalArgumentException.class, () -> method.invoke(s, 12));
    }
}
