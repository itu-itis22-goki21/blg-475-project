package gpt54.task0;

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
                () -> assertFalse(s.hasCloseElements(List.of(), 0.3)),
                () -> assertFalse(s.hasCloseElements(List.of(7.0), 0.3)),
                () -> assertTrue(s.hasCloseElements(List.of(11.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.3)),
                () -> assertFalse(s.hasCloseElements(List.of(1.0, 2.0, 3.9, 4.0, 5.0, 2.2), 0.05)),
                () -> assertTrue(s.hasCloseElements(List.of(1.0, 2.0, 5.9, 4.0, 5.0), 0.95)),
                () -> assertFalse(s.hasCloseElements(List.of(1.0, 2.0, 5.9, 4.0, 5.0), 0.8)),
                () -> assertTrue(s.hasCloseElements(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 2.0), 0.1)),
                () -> assertFalse(s.hasCloseElements(List.of(1.0, 2.0, 2.0, 3.0), 0.0)),
                () -> assertFalse(s.hasCloseElements(List.of(1.0, 1.3), 0.3)),
                () -> assertTrue(s.hasCloseElements(List.of(1.1, 2.2, 3.1, 4.1, 5.1), 1.0)),
                () -> assertFalse(s.hasCloseElements(List.of(1.1, 2.2, 3.1, 4.1, 5.1), 0.5))
        );
    }
}
