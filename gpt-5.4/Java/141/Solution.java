/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function which takes a string representing a file's name, and returns
    "Yes" if the the file's name is valid, and returns "No" otherwise.
    A file's name is considered to be valid if and only if all the following conditions
    are met:
    - There should not be more than three digits ('0'-'9') in the file's name.
    - The file's name contains exactly one dot '.'
    - The substring before the dot should not be empty, and it starts with a letter from
    the latin alphapet ('a'-'z' and 'A'-'Z').
    - The substring after the dot should be one of these: ["txt", "exe", "dll"]
    Examples:
    file_name_check("example.txt") # => "Yes"
    file_name_check("1example.dll") # => "No" (the name should start with a latin alphapet letter)
     */
    public String filenameCheck(String file_name) {
        if (file_name == null) {
            return "No";
        }

        int dotIndex = file_name.indexOf('.');
        if (dotIndex <= 0 || dotIndex != file_name.lastIndexOf('.')) {
            return "No";
        }

        int digitCount = 0;
        for (int i = 0; i < file_name.length(); i++) {
            if (Character.isDigit(file_name.charAt(i))) {
                digitCount++;
            }
        }
        if (digitCount > 3) {
            return "No";
        }

        String name = file_name.substring(0, dotIndex);
        String extension = file_name.substring(dotIndex + 1);
        if (name.isEmpty() || !Character.isLetter(name.charAt(0))) {
            return "No";
        }

        Set<String> validExtensions = new HashSet<>(Arrays.asList("txt", "exe", "dll"));
        return validExtensions.contains(extension) ? "Yes" : "No";
    }
}
