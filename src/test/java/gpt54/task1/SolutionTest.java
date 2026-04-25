package gpt54.task1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void separatesSpaceSeparatedGroups() {
        assertIterableEquals(
                List.of("(()())", "((()))", "()", "((())()())"),
                solution.separateParenGroups("(()()) ((())) () ((())()())")
        );
    }

    @Test
    void separatesAdjacentGroupsWithoutWhitespace() {
        assertIterableEquals(
                List.of("()", "(()())"),
                solution.separateParenGroups("()(()())")
        );
    }

    @Test
    void keepsSingleNestedGroupTogether() {
        assertIterableEquals(
                List.of("(()(())((())))"),
                solution.separateParenGroups("(()(())((())))")
        );
    }

    @Test
    void ignoresWhitespaceOnlyInput() {
        assertIterableEquals(List.of(), solution.separateParenGroups("   "));
    }
}
