package sonnet46.task69;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * You are given a non-empty list of positive integers. Return the greatest integer that is greater than
     * zero, and has a frequency greater than or equal to the value of the integer itself.
     * The frequency of an integer is the number of times it appears in the list.
     * If no such a value exist, return -1.
     * Examples:
     *     search(Arrays.asList(4, 1, 2, 2, 3, 1)) == 2
     *     search(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4)) == 3
     *     search(Arrays.asList(5, 5, 4, 4, 4)) == -1
     */
    public int search(List<Integer> lst) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : lst) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();
            if (val > 0 && count >= val) {
                result = Math.max(result, val);
            }
        }
        return result;
    }
}
