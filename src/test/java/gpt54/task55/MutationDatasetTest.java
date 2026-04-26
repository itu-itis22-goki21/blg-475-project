package gpt54.task55;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(1, s.fib(1)),
                () -> assertEquals(1, s.fib(2)),
                () -> assertEquals(2, s.fib(3)),
                () -> assertEquals(21, s.fib(8)),
                () -> assertEquals(55, s.fib(10)),
                () -> assertEquals(89, s.fib(11)),
                () -> assertEquals(144, s.fib(12)),
                () -> assertEquals(6765, s.fib(20)),
                () -> assertThrows(Throwable.class, () -> s.fib(0)),
                () -> assertThrows(Throwable.class, () -> s.fib(-1))
        );
    }
}
