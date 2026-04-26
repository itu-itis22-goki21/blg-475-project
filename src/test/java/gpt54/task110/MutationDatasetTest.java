package gpt54.task110;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals("YES", s.exchange(List.of(100, 200), List.of(200, 200))),
                () -> assertEquals("YES", s.exchange(List.of(1, 2, 3, 4), List.of(1, 2, 3, 4))),
                () -> assertEquals("NO", s.exchange(List.of(1, 2, 3, 4), List.of(1, 5, 3, 4))),
                () -> assertEquals("YES", s.exchange(List.of(1, 2, 3, 4), List.of(2, 1, 4, 3))),
                () -> assertEquals("YES", s.exchange(List.of(5, 7, 3), List.of(2, 6, 4))),
                () -> assertEquals("NO", s.exchange(List.of(5, 7, 3), List.of(2, 6, 3))),
                () -> assertEquals("NO", s.exchange(List.of(3, 2, 6, 1, 8, 9), List.of(3, 5, 5, 1, 1, 1))),
                () -> assertEquals("YES", s.exchange(List.of(1, 3, 5), List.of(2, 4, 6, 8)))
        );
    }
}
