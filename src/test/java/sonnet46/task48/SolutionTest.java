package sonnet46.task48;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome(""));
        assertTrue(s.isPalindrome("aba"));
        assertTrue(s.isPalindrome("aaaaa"));
        assertFalse(s.isPalindrome("zbcd"));
        assertTrue(s.isPalindrome("xywyx"));
        assertFalse(s.isPalindrome("xywyz"));
        assertFalse(s.isPalindrome("xywzx"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single character is always a palindrome
        assertTrue(s.isPalindrome("a"));
        // Even length palindrome
        assertTrue(s.isPalindrome("abba"));
        // Even length non-palindrome
        assertFalse(s.isPalindrome("abcd"));
        // Two same chars
        assertTrue(s.isPalindrome("aa"));
        // Two different chars
        assertFalse(s.isPalindrome("ab"));
    }
}
