package gpt54.task57;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertTrue(s.monotonic(List.of(7))),
                () -> assertTrue(s.monotonic(List.of(1, 2))),
                () -> assertTrue(s.monotonic(List.of(2, 1))),
                () -> assertTrue(s.monotonic(List.of(1, 2, 3))),
                () -> assertTrue(s.monotonic(List.of(3, 2, 1))),
                () -> assertFalse(s.monotonic(List.of(1, 3, 2))),
                () -> assertTrue(s.monotonic(List.of(1, 2, 4, 10))),
                () -> assertTrue(s.monotonic(List.of(1, 2, 4, 20))),
                () -> assertFalse(s.monotonic(List.of(1, 20, 4, 10))),
                () -> assertTrue(s.monotonic(List.of(4, 1, 0, -10))),
                () -> assertTrue(s.monotonic(List.of(4, 1, 1, 0))),
                () -> assertFalse(s.monotonic(List.of(1, 2, 3, 2, 5, 60))),
                () -> assertTrue(s.monotonic(List.of(1, 2, 3, 4, 5, 60))),
                () -> assertTrue(s.monotonic(List.of(9, 9, 9, 9)))
        );
    }
}
