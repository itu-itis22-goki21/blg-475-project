package gpt54.task48;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.lang.*;

public class SolutionTest {
    @Test
    void sampleCases()  {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isPalindrome(""),
                s.isPalindrome("aba"),
                s.isPalindrome("aaaaa"),
                !s.isPalindrome("zbcd"),
                s.isPalindrome("xywyx"),
                !s.isPalindrome("xywyz"),
                !s.isPalindrome("xywzx")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}


