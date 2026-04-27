package gpt54.task46;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    The Fib4 number sequence is a sequence similar to the Fibbonacci sequnece that's defined as follows:
    fib4(0) -> 0
    fib4(1) -> 0
    fib4(2) -> 2
    fib4(3) -> 0
    fib4(n) -> fib4(n-1) + fib4(n-2) + fib4(n-3) + fib4(n-4).
    Please write a function to efficiently compute the n-th element of the fib4 number sequence.  Do not use recursion.
    >>> fib4(5)
    4
    >>> fib4(6)
    8
    >>> fib4(7)
    14
     */
    public int fib4(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n == 0 || n == 1 || n == 3) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }

        int a = 0;
        int b = 0;
        int c = 2;
        int d = 0;
        for (int i = 4; i <= n; i++) {
            int next = a + b + c + d;
            a = b;
            b = c;
            c = d;
            d = next;
        }
        return d;
    }
}

