import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string, find out how many distinct characters (regardless of case) does it consist of
    >>> countDistinctCharacters("xyzXYZ")
    3
    >>> countDistinctCharacters("Jerry")
    4
     */
    public int countDistinctCharacters(String string) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            seen.add(Character.toLowerCase(string.charAt(i)));
        }
        return seen.size();
    }
}
