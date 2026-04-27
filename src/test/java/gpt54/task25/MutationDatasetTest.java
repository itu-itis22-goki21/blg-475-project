package gpt54.task25;

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
                () -> assertEquals(List.of(), s.factorize(1)),
                () -> assertEquals(List.of(2), s.factorize(2)),
                () -> assertEquals(List.of(13), s.factorize(13)),
                () -> assertEquals(List.of(2, 2), s.factorize(4)),
                () -> assertEquals(List.of(2, 2, 2), s.factorize(8)),
                () -> assertEquals(List.of(3, 19), s.factorize(3 * 19)),
                () -> assertEquals(List.of(3, 3, 19, 19), s.factorize(3 * 19 * 3 * 19)),
                () -> assertEquals(List.of(3, 3, 3, 19, 19, 19), s.factorize(3 * 19 * 3 * 19 * 3 * 19)),
                () -> assertEquals(List.of(3, 19, 19, 19), s.factorize(3 * 19 * 19 * 19)),
                () -> assertEquals(List.of(2, 3, 3), s.factorize(3 * 2 * 3)),
                () -> invokeWithBadArgument(s)
        );
    }

    private static void invokeWithBadArgument(Solution s) throws Exception {
        Method method = Solution.class.getDeclaredMethod("factorize", int.class);
        assertThrows(IllegalArgumentException.class, () -> method.invoke(s, "prime"));
    }
}
