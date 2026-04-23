package gpt54.task29;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class SolutionTest {
    @Test
    void sampleCases()  {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.filterByPrefix(new ArrayList<>(List.of()), "john").equals(List.of()),
                s.filterByPrefix(new ArrayList<>(Arrays.asList("xxx", "asd", "xxy", "john doe", "xxxAAA", "xxx")), "xxx").equals(Arrays.asList("xxx", "xxxAAA", "xxx"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}


