package sonnet46.task48;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertTrue(s.isPalindrome("")),
                () -> assertTrue(s.isPalindrome("x")),
                () -> assertTrue(s.isPalindrome("aa")),
                () -> assertFalse(s.isPalindrome("ab")),
                () -> assertTrue(s.isPalindrome("aba")),
                () -> assertTrue(s.isPalindrome("aaaaa")),
                () -> assertFalse(s.isPalindrome("zbcd")),
                () -> assertTrue(s.isPalindrome("xywyx")),
                () -> assertFalse(s.isPalindrome("xywyz")),
                () -> assertFalse(s.isPalindrome("xywzx")),
                () -> assertTrue(s.isPalindrome("aBa")),
                () -> assertFalse(s.isPalindrome("aBc")),
                () -> assertTrue(s.isPalindrome("a a")),
                () -> assertFalse(s.isPalindrome("ab a")),
                () -> assertTrue(s.isPalindrome("abcdefghhgfedcba")),
                () -> assertFalse(s.isPalindrome("abcdefghhgfedcbz")),
                () -> assertThrows(Throwable.class, () -> s.isPalindrome(null))
        );
    }
}
