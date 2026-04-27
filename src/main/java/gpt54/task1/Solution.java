package gpt54.task1;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input to this function is a string containing multiple groups of nested parentheses. Your goal is to
    separate those group into separate strings and return the list of those.
    Separate groups are balanced (each open brace is properly closed) and not nested within each other
    Ignore any spaces in the input string.
    >>> separateParenGroups("( ) (( )) (( )( ))")
    ["()", "(())", "(()())"]
     */
    public List<String> separateParenGroups(String paren_string) {
        if (paren_string == null) {
            throw new IllegalArgumentException("paren_string must not be null");
        }

        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int balance = 0;

        for (int i = 0; i < paren_string.length(); i++) {
            char ch = paren_string.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch != '(' && ch != ')') {
                throw new IllegalArgumentException("Input must contain only parentheses and spaces");
            }

            current.append(ch);
            if (ch == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    throw new IllegalArgumentException("Unbalanced parentheses");
                }
            }

            if (balance == 0 && current.length() > 0) {
                result.add(current.toString());
                current.setLength(0);
            }
        }

        if (balance != 0) {
            throw new IllegalArgumentException("Unbalanced parentheses");
        }

        return result;
    }
}

