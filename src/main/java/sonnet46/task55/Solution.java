package sonnet46.task55;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Return n-th Fibonacci number.
     * >>> fib(10)
     * 55
     * >>> fib(1)
     * 1
     * >>> fib(8)
     * 21
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
