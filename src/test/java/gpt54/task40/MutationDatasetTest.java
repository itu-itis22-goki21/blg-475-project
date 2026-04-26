package gpt54.task40;

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
                () -> assertFalse(s.triplesSumToZero(List.of(1))),
                () -> assertFalse(s.triplesSumToZero(List.of(1, 2))),
                () -> assertFalse(s.triplesSumToZero(List.of(1, 3, 5, 0))),
                () -> assertFalse(s.triplesSumToZero(List.of(1, 3, 5, -1))),
                () -> assertTrue(s.triplesSumToZero(List.of(1, 3, -2, 1))),
                () -> assertFalse(s.triplesSumToZero(List.of(1, 2, 3, 7))),
                () -> assertFalse(s.triplesSumToZero(List.of(1, 2, 5, 7))),
                () -> assertTrue(s.triplesSumToZero(List.of(2, 4, -5, 3, 9, 7))),
                () -> assertFalse(s.triplesSumToZero(List.of(-5, -4, -3, -2))),
                () -> assertFalse(s.triplesSumToZero(List.of(1, 1, 2, -4))),
                () -> assertTrue(s.triplesSumToZero(List.of(0, 0, 0)))
        );
    }
}
