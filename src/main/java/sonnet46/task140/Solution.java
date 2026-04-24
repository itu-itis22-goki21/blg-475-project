package sonnet46.task140;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Given a string text, replace all spaces in it with underscores,
     * and if a string has more than 2 consecutive spaces,
     * then replace all consecutive spaces with -
     *
     * fixSpaces("Example") == "Example"
     * fixSpaces("Example 1") == "Example_1"
     * fixSpaces(" Example 2") == "_Example_2"
     * fixSpaces(" Example   3") == "_Example-3"
     */
    public String fixSpaces(String text) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                int spaceCount = 0;
                while (i < text.length() && text.charAt(i) == ' ') {
                    spaceCount++;
                    i++;
                }
                if (spaceCount > 2) {
                    result.append('-');
                } else {
                    for (int s = 0; s < spaceCount; s++) {
                        result.append('_');
                    }
                }
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}
