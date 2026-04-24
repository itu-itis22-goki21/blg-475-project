package sonnet46.task57;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Return True if list elements are monotonically increasing or decreasing.
     * >>> monotonic(Arrays.asList(1, 2, 4, 20))
     * true
     * >>> monotonic(Arrays.asList(1, 20, 4, 10))
     * false
     * >>> monotonic(Arrays.asList(4, 1, 0, -10))
     * true
     */
    public boolean monotonic(List<Integer> l) {
        boolean increasing = true, decreasing = true;
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i) > l.get(i + 1)) increasing = false;
            if (l.get(i) < l.get(i + 1)) decreasing = false;
        }
        return increasing || decreasing;
    }
}
