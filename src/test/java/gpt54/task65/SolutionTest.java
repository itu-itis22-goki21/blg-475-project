package gpt54.task65;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.lang.*;

public class SolutionTest {
    @Test
    void sampleCases()  {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.circularShift(100, 2).equals("001"),
                s.circularShift(12, 2).equals("12"),
                s.circularShift(97, 8).equals("79"),
                s.circularShift(12, 1).equals("21"),
                s.circularShift(11, 101).equals("11")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}


