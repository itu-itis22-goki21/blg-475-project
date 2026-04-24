package sonnet46.task1;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Input to this function is a string containing multiple groups of nested parentheses. Your goal is to
     * separate those group into separate strings and return the list of those.
     * Separate groups are balanced (each open brace is properly closed) and not nested within each other.
     * Ignore any spaces in the input string.
     * >>> separateParenGroups("( ) (( )) (( )( ))")
     * ["()", "(())", "(()())"]
     */
    public List<String> separateParenGroups(String paren_string) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int depth = 0;

        for (char c : paren_string.toCharArray()) {
            if (c == ' ') continue;
            current.append(c);
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
                if (depth == 0) {
                    result.add(current.toString());
                    current.setLength(0);
                }
            }
        }
        return result;
    }
}
