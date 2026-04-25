package gpt54.task69;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("searchCases")
    void returnsExpectedCandidate(String description, List<Integer> values, int expected) {
        assertEquals(expected, solution.search(values));
    }

    private static Stream<Arguments> searchCases() {
        return Stream.of(
                Arguments.of("picks the largest qualifying value", List.of(4, 1, 4, 1, 4, 4), 4),
                Arguments.of("returns minus one when no value qualifies", List.of(5, 5, 4, 4, 4), -1),
                Arguments.of("returns one when only a single occurrence is enough", List.of(5, 5, 5, 5, 1), 1),
                Arguments.of("ignores zero and finds another qualifying value", List.of(0, 0, 0, 1), 1),
                Arguments.of("handles a single non-qualifying value", List.of(10), -1),
                Arguments.of("prefers the larger value when multiple qualify", List.of(1, 1, 2, 2, 2, 3, 3, 3), 3)
        );
    }
}
