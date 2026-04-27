package gpt54.task69;

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
                () -> assertEquals(-1, s.search(List.of())),
                () -> assertEquals(-1, s.search(List.of(-5, 0, -1))),
                () -> assertEquals(1, s.search(List.of(5, 5, 5, 5, 1))),
                () -> assertEquals(4, s.search(List.of(4, 1, 4, 1, 4, 4))),
                () -> assertEquals(-1, s.search(List.of(3, 3))),
                () -> assertEquals(8, s.search(List.of(8, 8, 8, 8, 8, 8, 8, 8))),
                () -> assertEquals(2, s.search(List.of(2, 3, 3, 2, 2))),
                () -> assertEquals(1, s.search(List.of(1))),
                () -> assertEquals(-1, s.search(List.of(10))),
                () -> assertThrows(Throwable.class, () -> s.search((List) List.of(1, "x")))
        );
    }
}
