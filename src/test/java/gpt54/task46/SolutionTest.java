package gpt54.task46;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.lang.*;

public class SolutionTest {
    @Test
    void sampleCases()  {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fib4(5) == 4,
                s.fib4(8) == 28,
                s.fib4(10) == 104,
                s.fib4(12) == 386
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}


