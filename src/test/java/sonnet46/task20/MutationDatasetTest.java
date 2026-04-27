package sonnet46.task20;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(List.of(1.0, 2.0), s.findClosestElements(List.of(1.0, 2.0))),
                () -> assertEquals(List.of(1.0, 2.0), s.findClosestElements(List.of(1.0, 2.0, 3.0))),
                () -> assertEquals(List.of(3.9, 4.0), s.findClosestElements(List.of(1.0, 2.0, 3.9, 4.0, 5.0, 2.2))),
                () -> assertEquals(List.of(5.0, 5.9), s.findClosestElements(List.of(1.0, 2.0, 5.9, 4.0, 5.0))),
                () -> assertEquals(List.of(2.0, 2.2), s.findClosestElements(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 2.2))),
                () -> assertEquals(List.of(2.0, 2.0), s.findClosestElements(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 2.0))),
                () -> assertEquals(List.of(2.2, 3.1), s.findClosestElements(List.of(1.1, 2.2, 3.1, 4.1, 5.1))),
                () -> assertThrows(Throwable.class, () -> s.findClosestElements(List.of(1.0)))
        );
    }
}
