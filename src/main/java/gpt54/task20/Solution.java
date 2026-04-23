package gpt54.task20;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    From a supplied list of numbers (of length at least two) select and return two that are the closest to each
    other and return them in order (smaller number, larger number).
    >>> findClosestElements(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.2))
    [2.0, 2.2]
    >>> findClosestElements(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0))
    [2.0, 2.0]
     */
    public List<Double> findClosestElements(List<Double> numbers) {
        List<Double> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);

        double bestA = sorted.get(0);
        double bestB = sorted.get(1);
        double bestDiff = bestB - bestA;

        for (int i = 2; i < sorted.size(); i++) {
            double currentA = sorted.get(i - 1);
            double currentB = sorted.get(i);
            double diff = currentB - currentA;
            if (diff < bestDiff) {
                bestDiff = diff;
                bestA = currentA;
                bestB = currentB;
            }
        }

        return Arrays.asList(bestA, bestB);
    }
}

