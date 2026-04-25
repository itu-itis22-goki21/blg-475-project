package gpt54.task55;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "fib({0}) = {1}")
    @CsvSource({
            "-5, 0",
            "0, 0",
            "1, 1",
            "2, 1",
            "8, 21",
            "10, 55",
            "12, 144"
    })
    void computesFibonacciValues(int n, int expected) {
        assertEquals(expected, solution.fib(n));
    }
}
