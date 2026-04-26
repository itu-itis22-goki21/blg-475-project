package gpt54.task65;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals("7", s.circularShift(7, 100)),
                () -> assertEquals("001", s.circularShift(100, 2)),
                () -> assertEquals("12", s.circularShift(12, 2)),
                () -> assertEquals("79", s.circularShift(97, 8)),
                () -> assertEquals("21", s.circularShift(12, 1)),
                () -> assertEquals("11", s.circularShift(11, 101))
        );
    }
}
