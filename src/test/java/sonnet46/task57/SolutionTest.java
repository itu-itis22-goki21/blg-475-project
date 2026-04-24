package sonnet46.task57;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 10))));
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 4, 20))));
        assertFalse(s.monotonic(new ArrayList<>(Arrays.asList(1, 20, 4, 10))));
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 0, -10))));
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(4, 1, 1, 0))));
        assertFalse(s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 5, 60))));
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 60))));
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(9, 9, 9, 9))));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single element is monotonic
        assertTrue(s.monotonic(new ArrayList<>(List.of(5))));
        // Two elements — strictly increasing
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(1, 2))));
        // Two elements — strictly decreasing
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(2, 1))));
        // Two equal elements — flat (both directions hold)
        assertTrue(s.monotonic(new ArrayList<>(Arrays.asList(3, 3))));
        // Goes up then down
        assertFalse(s.monotonic(new ArrayList<>(Arrays.asList(1, 3, 2))));
    }
}
