package sonnet46.task156;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.util.Locale;
import java.lang.*;

class Solution {
    /**
     * Given a positive integer, obtain its roman numeral equivalent as a string,
     * and return it in lowercase.
     * Restrictions: 1 <= num <= 1000
     *
     * >>> intToMiniRoman(19) == "xix"
     * >>> intToMiniRoman(152) == "clii"
     * >>> intToMiniRoman(426) == "cdxxvi"
     */
    public String intToMiniRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                sb.append(symbols[i]);
                number -= values[i];
            }
        }
        return sb.toString().toLowerCase(Locale.ROOT);
    }
}
