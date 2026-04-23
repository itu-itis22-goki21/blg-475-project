package gpt54.task57;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.lang.*;

public class SolutionTest {
    @Test
    void sampleCases()  {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 20))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 20, 4, 10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 0, -10))),
                s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 1, 0))),
                !s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 60))),
                s.monotonic(new ArrayList<>(Arrays.asList(9, 9, 9, 9)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}


