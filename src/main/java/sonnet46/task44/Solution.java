package sonnet46.task44;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Change numerical base of input number x to base.
     * return string representation after the conversion.
     * base numbers are less than 10.
     * >>> changeBase(8, 3)
     * "22"
     * >>> changeBase(8, 2)
     * "1000"
     * >>> changeBase(7, 2)
     * "111"
     */
    public String changeBase(int x, int base) {
        if (x == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(x % base);
            x /= base;
        }
        return sb.reverse().toString();
    }
}
