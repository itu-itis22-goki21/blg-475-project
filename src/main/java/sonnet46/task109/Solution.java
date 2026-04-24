package sonnet46.task109;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * We have an array 'arr' of N integers. Your task is to determine if it is possible to get an array
     * sorted in non-decreasing order by performing right shift operations any number of times.
     * If the given array is empty then return true.
     * Note: The given list is guaranteed to have unique elements.
     *
     * moveOneBall(Arrays.asList(3, 4, 5, 1, 2))==>true
     * moveOneBall(Arrays.asList(3, 5, 4, 1, 2))==>False
     */
    public boolean moveOneBall(List<Integer> arr) {
        if (arr.isEmpty()) return true;
        int descents = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > arr.get((i + 1) % n)) {
                descents++;
            }
        }
        return descents <= 1;
    }
}
