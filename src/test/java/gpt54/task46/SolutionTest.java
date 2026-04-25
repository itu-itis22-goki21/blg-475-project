package gpt54.task46;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "fib4({0}) = {1}")
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 2",
            "3, 0",
            "4, 2",
            "5, 4",
            "8, 28",
            "12, 386"
    })
    void computesFib4Values(int n, int expected) {
        assertEquals(expected, solution.fib4(n));
    }
}
