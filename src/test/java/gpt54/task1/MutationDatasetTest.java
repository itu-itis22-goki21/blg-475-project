package gpt54.task1;

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
                () -> assertEquals(List.of(), s.separateParenGroups("")),
                () -> assertEquals(List.of(), s.separateParenGroups("   ")),
                () -> assertEquals(List.of("()"), s.separateParenGroups("()")),
                () -> assertEquals(List.of("((()))"), s.separateParenGroups("((()))")),
                () -> assertEquals(List.of("(()(())((())))"), s.separateParenGroups("(()(())((())))")),
                () -> assertEquals(List.of("()", "()"), s.separateParenGroups("()()")),
                () -> assertEquals(List.of("()", "()"), s.separateParenGroups("() ()")),
                () -> assertEquals(
                        List.of("(()())", "((()))", "()", "((())()())"),
                        s.separateParenGroups("(()()) ((())) () ((())()())")
                ),
                () -> assertEquals(
                        List.of("()", "(())", "((()))", "(((())))"),
                        s.separateParenGroups("() (()) ((())) (((())))")
                ),
                () -> assertEquals(List.of("()", "(())", "(()())"), s.separateParenGroups("( ) (( )) (( )( ))")),
                () -> assertThrows(Throwable.class, () -> s.separateParenGroups("(()"))
        );
    }
}
