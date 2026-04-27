package gpt54.task58;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(List.of(), s.common(List.of(), List.of())),
                () -> assertEquals(List.of(), s.common(List.of(4, 3, 2, 8), List.of())),
                () -> assertEquals(List.of(), s.common(List.of(), List.of(1, 2, 3))),
                () -> assertEquals(List.of(1, 5, 653), s.common(List.of(1, 4, 3, 34, 653, 2, 5), List.of(5, 7, 1, 5, 9, 653, 121))),
                () -> assertEquals(List.of(2, 3), s.common(List.of(5, 3, 2, 8), List.of(3, 2))),
                () -> assertEquals(List.of(2, 3, 4), s.common(List.of(4, 3, 2, 8), List.of(3, 2, 4))),
                () -> assertEquals(List.of(2, 3), s.common(List.of(1, 2, 2, 3, 3), List.of(3, 2, 2, 4))),
                () -> assertEquals(List.of(5), s.common(List.of(5, 1, 9), List.of(4, 5, 6))),
                () -> assertThrows(ClassCastException.class, () -> s.common(List.of(1), (List) List.of("x", 1)))
        );
    }
}
