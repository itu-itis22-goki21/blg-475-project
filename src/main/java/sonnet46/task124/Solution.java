package sonnet46.task124;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * You have to write a function which validates a given date string and
     * returns true if the date is valid otherwise false.
     * The date is valid if all of the following rules are satisfied:
     * 1. The date string is not empty.
     * 2. The number of days is not less than 1 or higher than 31 days for months 1,3,5,7,8,10,12.
     *    And the number of days is not less than 1 or higher than 30 days for months 4,6,9,11.
     *    And, the number of days is not less than 1 or higher than 29 for the month 2.
     * 3. The months should not be less than 1 or higher than 12.
     * 4. The date should be in the format: mm-dd-yyyy
     *
     * validDate("03-11-2000") => true
     * validDate("15-01-2012") => false
     */
    public boolean validDate(String date) {
        try {
            if (date == null || date.trim().isEmpty()) return false;
            String[] parts = date.trim().split("-");
            if (parts.length != 3) return false;
            if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) return false;
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            if (month < 1 || month > 12) return false;
            if (day < 1) return false;
            int[] maxDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            return day <= maxDays[month];
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
