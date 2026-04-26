package gpt54.task8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(List.of(0, 1), s.sumProduct(List.of())),
                () -> assertEquals(List.of(10, 10), s.sumProduct(List.of(10))),
                () -> assertEquals(List.of(3, 1), s.sumProduct(List.of(1, 1, 1))),
                () -> assertEquals(List.of(100, 0), s.sumProduct(List.of(100, 0))),
                () -> assertEquals(List.of(15, 105), s.sumProduct(List.of(3, 5, 7))),
                () -> assertEquals(List.of(-2, 6), s.sumProduct(List.of(-1, 2, -3))),
                () -> assertEquals(List.of(3000, 2_000_000), s.sumProduct(List.of(1000, 2000)))
        );
    }
}
