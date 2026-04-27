package gpt54.task5;

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
                () -> assertEquals(List.of(), s.intersperse(List.of(), 7)),
                () -> assertEquals(List.of(9), s.intersperse(List.of(9), 3)),
                () -> assertEquals(List.of(1, 0, 2), s.intersperse(List.of(1, 2), 0)),
                () -> assertEquals(List.of(5, 8, 6, 8, 3, 8, 2), s.intersperse(List.of(5, 6, 3, 2), 8)),
                () -> assertEquals(List.of(2, 2, 2, 2, 2), s.intersperse(List.of(2, 2, 2), 2)),
                () -> assertThrows(ClassCastException.class, () -> s.intersperse((List) List.of(1, "x"), 3)),
                () -> invokeWithBadDelimiter(s)
        );
    }

    private static void invokeWithBadDelimiter(Solution s) throws Exception {
        Method method = Solution.class.getDeclaredMethod("intersperse", List.class, int.class);
        assertThrows(IllegalArgumentException.class, () -> method.invoke(s, List.of(1, 2), "bad"));
    }
}
