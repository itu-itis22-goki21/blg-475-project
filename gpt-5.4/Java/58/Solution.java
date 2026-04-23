/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return sorted unique common elements for two lists.
    >>> common(Arrays.asList(1, 4, 3, 34, 653, 2, 5), Arrays.asList(5, 7, 1, 5, 9, 653, 121))
    [1, 5, 653]
    >>> common(Arrays.asList(5, 3, 2, 8), Arrays.asList(3, 2))
    [2, 3]
     */
    public List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> values = new HashSet<>(l1);
        Set<Integer> resultSet = new HashSet<>();

        for (int value : l2) {
            if (values.contains(value)) {
                resultSet.add(value);
            }
        }

        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
