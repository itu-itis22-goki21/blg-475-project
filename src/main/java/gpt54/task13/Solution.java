package gpt54.task13;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return a greatest common divisor of two integers a and b
    >>> greatestCommonDivisor(3, 5)
    1
    >>> greatestCommonDivisor(25, 15)
    5
     */
    public int greatestCommonDivisor(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("gcd(0, 0) is undefined");
        }

        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int next = a % b;
            a = b;
            b = next;
        }
        return a;
    }
}

