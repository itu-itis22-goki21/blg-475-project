package sonnet46.task1;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("(()())", "((()))", "()", "((())()())"),
                s.separateParenGroups("(()()) ((())) () ((())()())"));
        assertEquals(Arrays.asList("()", "(())", "((()))", "(((())))"),
                s.separateParenGroups("() (()) ((())) (((())))"));
        assertEquals(Arrays.asList("(()(())((())))"),
                s.separateParenGroups("(()(())((())))"));
        assertEquals(Arrays.asList("()", "(())", "(()())"),
                s.separateParenGroups("( ) (( )) (( )( ))"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Empty string: no groups
        assertEquals(Collections.emptyList(), s.separateParenGroups(""));
        // Only spaces: no groups
        assertEquals(Collections.emptyList(), s.separateParenGroups("   "));
        // Single group
        assertEquals(List.of("()"), s.separateParenGroups("()"));
        // Deeply nested single group
        assertEquals(List.of("((()))"), s.separateParenGroups("((()))"));
    }
}
