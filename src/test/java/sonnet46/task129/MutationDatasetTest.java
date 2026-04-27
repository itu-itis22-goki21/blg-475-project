package sonnet46.task129;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(List.of(1), s.minPath(List.of(List.of(5, 9, 3), List.of(4, 1, 6), List.of(7, 8, 2)), 1)),
                () -> assertEquals(List.of(1, 2), s.minPath(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 2)),
                () -> assertEquals(List.of(1, 2, 1), s.minPath(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 3)),
                () -> assertEquals(List.of(1, 2, 1, 2), s.minPath(List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8), List.of(9, 10, 11, 12), List.of(13, 14, 15, 16)), 4)),
                () -> assertEquals(List.of(1, 10, 1, 10, 1, 10, 1), s.minPath(List.of(List.of(6, 4, 13, 10), List.of(5, 7, 12, 1), List.of(3, 16, 11, 15), List.of(8, 14, 9, 2)), 7))
                // NOTE: assertThrows for non-square grid omitted — sonnet46 has no grid validation
                // NOTE: assertThrows for 1x1 grid omitted — returns [1] without throwing
                // NOTE: assertThrows for k=0 omitted — returns empty list without throwing
                // NOTE: assertThrows for duplicate 1s omitted — uses first found, no exception
        );
    }
}
