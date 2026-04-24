package sonnet46.task110;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * In this problem, you will implement a function that takes two lists of numbers,
     * and determines whether it is possible to perform an exchange of elements
     * between them to make lst1 a list of only even numbers.
     * There is no limit on the number of exchanged elements between lst1 and lst2.
     * If it is possible to exchange elements between the lst1 and lst2 to make
     * all the elements of lst1 to be even, return "YES".
     * Otherwise, return "NO".
     * For example:
     * exchange(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2, 3, 4)) => "YES"
     * exchange(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 5, 3, 4)) => "NO"
     */
    public String exchange(List<Integer> lst1, List<Integer> lst2) {
        long oddsInLst1 = lst1.stream().filter(x -> x % 2 != 0).count();
        long evensInLst2 = lst2.stream().filter(x -> x % 2 == 0).count();
        return evensInLst2 >= oddsInLst1 ? "YES" : "NO";
    }
}
