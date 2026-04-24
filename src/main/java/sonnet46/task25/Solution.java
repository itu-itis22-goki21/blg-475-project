package sonnet46.task25;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Return list of prime factors of given integer in the order from smallest to largest.
     * Each of the factors should be listed number of times corresponding to how many times it appears in factorization.
     * Input number should be equal to the product of all factors
     * >>> factorize(8)
     * [2, 2, 2]
     * >>> factorize(25)
     * [5, 5]
     * >>> factorize(70)
     * [2, 5, 7]
     */
    public List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int divisor = 2; divisor * divisor <= n; divisor++) {
            while (n % divisor == 0) {
                factors.add(divisor);
                n /= divisor;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}
