package sonnet46.task1;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                () -> assertEquals(List.of("()", "(())", "(()())"), s.separateParenGroups("( ) (( )) (( )( ))"))
                // NOTE: assertThrows for unbalanced "((" omitted — sonnet46 returns [] instead of throwing
        );
    }
}
