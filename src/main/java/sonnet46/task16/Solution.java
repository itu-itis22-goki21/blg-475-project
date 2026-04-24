package sonnet46.task16;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Given a string, find out how many distinct characters (regardless of case) does it consist of
     * >>> countDistinctCharacters("xyzXYZ")
     * 3
     * >>> countDistinctCharacters("Jerry")
     * 4
     */
    public int countDistinctCharacters(String string) {
        Set<Character> distinct = new HashSet<>();
        for (char c : string.toLowerCase().toCharArray()) {
            distinct.add(c);
        }
        return distinct.size();
    }
}
