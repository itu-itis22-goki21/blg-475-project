package sonnet46.task65;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Circular shift the digits of the integer x, shift the digits right by shift
     * and return the result as a string.
     * If shift > number of digits, return digits reversed.
     * >>> circularShift(12, 1)
     * "21"
     * >>> circularShift(12, 2)
     * "12"
     */
    public String circularShift(int x, int shift) {
        String digits = String.valueOf(x);
        int len = digits.length();
        if (shift > len) {
            return new StringBuilder(digits).reverse().toString();
        }
        int cutPoint = len - shift;
        return digits.substring(cutPoint) + digits.substring(0, cutPoint);
    }
}
