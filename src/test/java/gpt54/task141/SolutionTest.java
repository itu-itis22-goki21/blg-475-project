package gpt54.task141;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("fileNameCases")
    void validatesFileNames(String description, String fileName, String expected) {
        assertEquals(expected, solution.filenameCheck(fileName));
    }

    private static Stream<Arguments> fileNameCases() {
        return Stream.of(
                Arguments.of("accepts a simple txt file", "example.txt", "Yes"),
                Arguments.of("accepts exactly three digits in the file name", "A12b3.exe", "Yes"),
                Arguments.of("rejects null", null, "No"),
                Arguments.of("rejects names that start with a digit", "1example.dll", "No"),
                Arguments.of("rejects multiple dots", "all.exe.txt", "No"),
                Arguments.of("rejects an empty name before the dot", ".txt", "No"),
                Arguments.of("rejects too many digits", "His12FILE94.exe", "No"),
                Arguments.of("rejects unsupported extensions", "this_is_valid.wow", "No"),
                Arguments.of("rejects missing extensions", "final132", "No"),
                Arguments.of("rejects empty extensions", "name.", "No")
        );
    }
}
