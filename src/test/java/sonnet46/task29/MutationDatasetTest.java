package sonnet46.task29;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(List.of(), s.filterByPrefix(List.of(), "john")),
                () -> assertEquals(List.of("alpha", "beta"), s.filterByPrefix(List.of("alpha", "beta"), "")),
                () -> assertEquals(List.of(), s.filterByPrefix(List.of("cat", "dog"), "zzz")),
                () -> assertEquals(List.of(), s.filterByPrefix(List.of("cat", "dog"), "longer-than-any-entry")),
                () -> assertEquals(
                        List.of("xxx", "xxxAAA", "xxx"),
                        s.filterByPrefix(List.of("xxx", "asd", "xxy", "john doe", "xxxAAA", "xxx"), "xxx")
                ),
                () -> assertEquals(List.of("Case"), s.filterByPrefix(List.of("Case", "case", "cases"), "Cas")),
                () -> assertThrows(ClassCastException.class, () -> s.filterByPrefix((List) List.of("ok", 1), "o")),
                () -> invokeWithBadPrefix(s)
        );
    }

    private static void invokeWithBadPrefix(Solution s) throws Exception {
        Method method = Solution.class.getDeclaredMethod("filterByPrefix", List.class, String.class);
        assertThrows(IllegalArgumentException.class, () -> method.invoke(s, List.of("abc"), 123));
    }
}
