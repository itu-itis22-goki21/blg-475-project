package gpt54.task44;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Change numerical base of input number x to base.
    return string representation after the conversion.
    base numbers are less than 10.
    >>> changeBase(8, 3)
    "22"
    >>> changeBase(8, 2)
    "1000"
    >>> changeBase(7, 2)
    "111"
     */
    public String changeBase(int x, int base) {
        if (base <= 1 || base > 10) {
            throw new IllegalArgumentException("base must be between 2 and 10");
        }
        if (x < 0) {
            throw new IllegalArgumentException("x must be non-negative");
        }
        if (x == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int value = x;
        while (value > 0) {
            result.append(value % base);
            value /= base;
        }
        return result.reverse().toString();
    }
}

