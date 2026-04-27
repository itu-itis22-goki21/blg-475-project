package sonnet46.task109;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertTrue(s.moveOneBall(List.of())),
                () -> assertTrue(s.moveOneBall(List.of(5))),
                () -> assertTrue(s.moveOneBall(List.of(1, 2, 3, 4))),
                () -> assertTrue(s.moveOneBall(List.of(2, 3, 4, 1))),
                () -> assertTrue(s.moveOneBall(List.of(3, 4, 5, 1, 2))),
                () -> assertTrue(s.moveOneBall(List.of(3, 5, 10, 1, 2))),
                () -> assertFalse(s.moveOneBall(List.of(4, 3, 1, 2))),
                () -> assertFalse(s.moveOneBall(List.of(3, 5, 4, 1, 2))),
                () -> assertThrows(Throwable.class, () -> s.moveOneBall((List) List.of(1, "x", 2)))
        );
    }
}
