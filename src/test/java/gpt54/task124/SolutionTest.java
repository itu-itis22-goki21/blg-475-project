package gpt54.task124;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("dateCases")
    void validatesDatesAsExpected(String description, String date, boolean expected) {
        assertEquals(expected, solution.validDate(date));
    }

    private static Stream<Arguments> dateCases() {
        return Stream.of(
                Arguments.of("accepts a normal valid date", "03-11-2000", true),
                Arguments.of("accepts the maximum day in a 31 day month", "12-31-1999", true),
                Arguments.of("accepts February 29 because the implementation allows it", "02-29-2024", true),
                Arguments.of("rejects null input", null, false),
                Arguments.of("rejects an empty string", "", false),
                Arguments.of("rejects the wrong format", "6-04-2020", false),
                Arguments.of("rejects slashes instead of dashes", "06/04/2020", false),
                Arguments.of("rejects month zero", "00-10-2020", false),
                Arguments.of("rejects months above twelve", "13-01-2020", false),
                Arguments.of("rejects day zero", "02-00-2020", false),
                Arguments.of("rejects a day above the month limit", "04-31-3000", false),
                Arguments.of("rejects February 30", "02-30-2020", false)
        );
    }
}
