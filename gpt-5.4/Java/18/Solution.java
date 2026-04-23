/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Find how many times a given substring can be found in the original string. Count overlaping cases.
    >>> howManyTimes("", "a")
    0
    >>> howManyTimes("aaa", "a")
    3
    >>> howManyTimes("aaaa", "aa")
    3
     */
    public int howManyTimes(String string, String substring) {
        if (substring.isEmpty() || string.length() < substring.length()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.startsWith(substring, i)) {
                count++;
            }
        }
        return count;
    }
}
