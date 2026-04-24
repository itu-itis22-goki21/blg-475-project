package sonnet46.task20;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * From a supplied list of numbers (of length at least two) select and return two that are the closest to each
     * other and return them in order (smaller number, larger number).
     * >>> findClosestElements(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.2))
     * [2.0, 2.2]
     * >>> findClosestElements(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0))
     * [2.0, 2.0]
     */
    public List<Double> findClosestElements(List<Double> numbers) {
        List<Double> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        double minDiff = Double.MAX_VALUE;
        double a = sorted.get(0), b = sorted.get(1);
        for (int i = 0; i < sorted.size() - 1; i++) {
            double diff = sorted.get(i + 1) - sorted.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                a = sorted.get(i);
                b = sorted.get(i + 1);
            }
        }
        return Arrays.asList(a, b);
    }
}
