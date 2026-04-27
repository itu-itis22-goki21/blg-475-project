package sonnet46.task141;

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
                () -> assertEquals("Yes", s.filenameCheck("example.txt")),
                () -> assertEquals("No", s.filenameCheck(".txt")),
                () -> assertEquals("No", s.filenameCheck("name.EXE")),
                () -> assertEquals("No", s.filenameCheck("1example.dll")),
                () -> assertEquals("No", s.filenameCheck("s1sdf3.asd")),
                () -> assertEquals("Yes", s.filenameCheck("K.dll")),
                () -> assertEquals("Yes", s.filenameCheck("MY16FILE3.exe")),
                () -> assertEquals("No", s.filenameCheck("His12FILE94.exe")),
                () -> assertEquals("No", s.filenameCheck("_Y.txt")),
                () -> assertEquals("No", s.filenameCheck("?aREYA.exe")),
                () -> assertEquals("No", s.filenameCheck("/this_is_valid.dll")),
                () -> assertEquals("No", s.filenameCheck("this_is_valid.wow")),
                () -> assertEquals("Yes", s.filenameCheck("this_is_valid.txt")),
                () -> assertEquals("No", s.filenameCheck("this_is_valid.txtexe")),
                () -> assertEquals("No", s.filenameCheck("#this2_i4s_5valid.ten")),
                () -> assertEquals("No", s.filenameCheck("@this1_is6_valid.exe")),
                () -> assertEquals("No", s.filenameCheck("this_is_12valid.6exe4.txt")),
                () -> assertEquals("No", s.filenameCheck("all.exe.txt")),
                () -> assertEquals("Yes", s.filenameCheck("I563_No.exe")),
                () -> assertEquals("Yes", s.filenameCheck("Is3youfault.txt")),
                () -> assertEquals("Yes", s.filenameCheck("no_one#knows.dll")),
                () -> assertEquals("No", s.filenameCheck("1I563_Yes3.exe")),
                () -> assertEquals("No", s.filenameCheck("I563_Yes3.txtt")),
                () -> assertEquals("No", s.filenameCheck("final..txt")),
                () -> assertEquals("No", s.filenameCheck("final132")),
                () -> assertEquals("No", s.filenameCheck("_f4indsartal132.")),
                () -> assertEquals("No", s.filenameCheck(null)),
                () -> invokeWithBadArgument(s)
        );
    }

    private static void invokeWithBadArgument(Solution s) throws Exception {
        Method method = Solution.class.getDeclaredMethod("filenameCheck", String.class);
        assertThrows(IllegalArgumentException.class, () -> method.invoke(s, 10));
    }
}
