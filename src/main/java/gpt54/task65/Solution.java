package gpt54.task65;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Circular shift the digits of the integer x, shift the digits right by shift
    and return the result as a string.
    If shift > number of digits, return digits reversed.
    >>> circularShift(12, 1)
    "21"
    >>> circularShift(12, 2)
    "12"
     */
    public String circularShift(int x, int shift) {
        String digits = Integer.toString(x);
        int n = digits.length();

        if (shift > n) {
            return new StringBuilder(digits).reverse().toString();
        }

        int effectiveShift = shift % n;
        if (effectiveShift == 0) {
            return digits;
        }

        return digits.substring(n - effectiveShift) + digits.substring(0, n - effectiveShift);
    }
}

