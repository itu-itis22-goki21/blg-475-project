package sonnet46.task32;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Evaluates polynomial with coefficients xs at point x.
     * return xs[0] + xs[1] * x + xs[1] * x^2 + .... xs[n] * x^n
     */
    public double poly(List<Double> xs, double x) {
        double result = 0;
        for (int i = 0; i < xs.size(); i++) {
            result += xs.get(i) * Math.pow(x, i);
        }
        return result;
    }

    /**
     * xs are coefficients of a polynomial.
     * findZero find x such that poly(x) = 0.
     * findZero returns only one zero point, even if there are many.
     * Moreover, findZero only takes list xs having even number of coefficients
     * and largest non zero coefficient as it guarantees a solution.
     * >>> findZero(Arrays.asList(1, 2)) // f(x) = 1 + 2x
     * -0.5
     * >>> findZero(Arrays.asList(-6, 11, -6, 1)) // (x-1)*(x-2)*(x-3)
     * 1.0
     */
    public double findZero(List<Double> xs) {
        double lo = -1, hi = 1;
        while (poly(xs, lo) * poly(xs, hi) > 0) {
            lo *= 2;
            hi *= 2;
        }
        for (int i = 0; i < 100; i++) {
            double mid = (lo + hi) / 2.0;
            if (poly(xs, lo) * poly(xs, mid) <= 0) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return (lo + hi) / 2.0;
    }
}
