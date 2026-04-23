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
