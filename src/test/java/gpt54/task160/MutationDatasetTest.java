package gpt54.task160;

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
                () -> assertEquals(64, s.doAlgebra(List.of("**", "**"), List.of(2, 3, 2))),
                () -> assertEquals(13, s.doAlgebra(List.of("+", "-", "+"), List.of(10, 2, 3, 4))),
                () -> assertEquals(6, s.doAlgebra(List.of("/", "+", "-"), List.of(20, 5, 3, 1))),
                () -> assertEquals(37, s.doAlgebra(List.of("**", "*", "+"), List.of(2, 3, 4, 5))),
                () -> assertEquals(9, s.doAlgebra(List.of("+", "*", "-"), List.of(2, 3, 4, 5))),
                () -> assertEquals(1953132, s.doAlgebra(List.of("+", "**", "**"), List.of(7, 5, 3, 2))),
                () -> assertEquals(35, s.doAlgebra(List.of("*"), List.of(7, 5))),
                () -> assertThrows(Throwable.class, () -> s.doAlgebra(List.of(), List.of(1))),
                () -> assertThrows(Throwable.class, () -> s.doAlgebra(List.of("+"), List.of())),
                () -> assertThrows(Throwable.class, () -> s.doAlgebra(List.of("+", "-"), List.of(1, 2)))
        );
    }
}
