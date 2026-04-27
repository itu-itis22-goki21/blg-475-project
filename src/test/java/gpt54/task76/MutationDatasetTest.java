package gpt54.task76;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertTrue(s.isSimplePower(1, 4)),
                () -> assertTrue(s.isSimplePower(2, 2)),
                () -> assertTrue(s.isSimplePower(8, 2)),
                () -> assertFalse(s.isSimplePower(3, 2)),
                () -> assertFalse(s.isSimplePower(3, 1)),
                () -> assertFalse(s.isSimplePower(5, 3)),
                () -> assertTrue(s.isSimplePower(16, 2)),
                () -> assertFalse(s.isSimplePower(143214, 16)),
                () -> assertTrue(s.isSimplePower(4, 2)),
                () -> assertTrue(s.isSimplePower(9, 3)),
                () -> assertTrue(s.isSimplePower(16, 4)),
                () -> assertFalse(s.isSimplePower(24, 2)),
                () -> assertFalse(s.isSimplePower(128, 4)),
                () -> assertFalse(s.isSimplePower(12, 6)),
                () -> assertTrue(s.isSimplePower(1, 1)),
                () -> assertTrue(s.isSimplePower(1, 12)),
                () -> assertFalse(s.isSimplePower(-8, 2)),
                () -> assertFalse(s.isSimplePower(8, -2)),
                () -> assertFalse(s.isSimplePower(-8, -2))
        );
    }
}
