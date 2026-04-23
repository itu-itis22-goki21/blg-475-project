package gpt54.task140;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string text, replace all spaces in it with underscores,
    and if a string has more than 2 consecutive spaces,
    then replace all consecutive spaces with -

    fixSpaces("Example") == "Example"
    fixSpaces("Example 1") == "Example_1"
    fixSpaces(" Example 2") == "_Example_2"
    fixSpaces(" Example   3") == "_Example-3"
     */
    public String fixSpaces(String text) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            if (text.charAt(i) != ' ') {
                result.append(text.charAt(i));
                i++;
                continue;
            }

            int j = i;
            while (j < text.length() && text.charAt(j) == ' ') {
                j++;
            }

            int count = j - i;
            if (count > 2) {
                result.append('-');
            } else {
                for (int k = 0; k < count; k++) {
                    result.append('_');
                }
            }
            i = j;
        }

        return result.toString();
    }
}

