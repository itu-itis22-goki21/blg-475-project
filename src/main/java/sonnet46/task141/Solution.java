package sonnet46.task141;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Create a function which takes a string representing a file's name, and returns
     * "Yes" if the the file's name is valid, and returns "No" otherwise.
     * A file's name is considered to be valid if and only if all the following conditions are met:
     * - There should not be more than three digits ('0'-'9') in the file's name.
     * - The file's name contains exactly one dot '.'
     * - The substring before the dot should not be empty, and it starts with a letter from the latin alphabet.
     * - The substring after the dot should be one of these: ["txt", "exe", "dll"]
     */
    public String filenameCheck(String file_name) {
        if (file_name == null || file_name.isEmpty()) return "No";
        String[] parts = file_name.split("\\.", -1);
        if (parts.length != 2) return "No";
        String name = parts[0];
        String ext = parts[1];
        if (name.isEmpty() || !Character.isLetter(name.charAt(0))) return "No";
        if (!ext.equals("txt") && !ext.equals("exe") && !ext.equals("dll")) return "No";
        long digitCount = file_name.chars().filter(Character::isDigit).count();
        if (digitCount > 3) return "No";
        return "Yes";
    }
}
