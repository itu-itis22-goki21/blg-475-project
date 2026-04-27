package sonnet46.task160;

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
                () -> assertEquals(10, s.doAlgebra(List.of("+", "+", "+"), List.of(1, 2, 3, 4))),
                () -> assertEquals(5, s.doAlgebra(List.of("-", "-"), List.of(10, 3, 2))),
                () -> assertEquals(24, s.doAlgebra(List.of("*", "*"), List.of(2, 3, 4))),
                () -> assertEquals(8, s.doAlgebra(List.of("/", "*"), List.of(7, 3, 4))),
                () -> assertEquals(8, s.doAlgebra(List.of("/", "/"), List.of(64, 4, 2))),
                // NOTE: sonnet46 evaluates ** right-to-left: 2^(3^2) = 2^9 = 512 (not 64)
                () -> assertEquals(512, s.doAlgebra(List.of("**", "**"), List.of(2, 3, 2))),
                () -> assertEquals(13, s.doAlgebra(List.of("+", "-", "+"), List.of(10, 2, 3, 4))),
                () -> assertEquals(6, s.doAlgebra(List.of("/", "+", "-"), List.of(20, 5, 3, 1))),
                () -> assertEquals(37, s.doAlgebra(List.of("**", "*", "+"), List.of(2, 3, 4, 5))),
                () -> assertEquals(9, s.doAlgebra(List.of("+", "*", "-"), List.of(2, 3, 4, 5))),
                // NOTE: sonnet46 right-to-left **: 5^(3^2) = 5^9 = 1953125; +7 = 1953132 (not 15632)
                () -> assertEquals(1953132, s.doAlgebra(List.of("+", "**", "**"), List.of(7, 5, 3, 2))),
                () -> assertEquals(35, s.doAlgebra(List.of("*"), List.of(7, 5))),
                // NOTE: empty ops with 1 operand returns operand[0]=1 without throwing
                () -> assertEquals(1, s.doAlgebra(List.of(), List.of(1))),
                () -> assertThrows(Throwable.class, () -> s.doAlgebra(List.of("+"), List.of())),
                () -> assertThrows(Throwable.class, () -> s.doAlgebra(List.of("+", "-"), List.of(1, 2)))
        );
    }
}
