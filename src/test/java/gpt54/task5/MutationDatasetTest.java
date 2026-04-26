package gpt54.task5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(List.of(), s.intersperse(List.of(), 7)),
                () -> assertEquals(List.of(9), s.intersperse(List.of(9), 3)),
                () -> assertEquals(List.of(1, 0, 2), s.intersperse(List.of(1, 2), 0)),
                () -> assertEquals(List.of(5, 8, 6, 8, 3, 8, 2), s.intersperse(List.of(5, 6, 3, 2), 8)),
                () -> assertEquals(List.of(2, 2, 2, 2, 2), s.intersperse(List.of(2, 2, 2), 2))
        );
    }
}
