package sonnet46.task0;

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
        assertTrue(s.hasCloseElements(new ArrayList<>(Arrays.asList(11.0, 2.0, 3.9, 4.0, 5.0, 2.2)), 0.3));
        assertFalse(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2)), 0.05));
        assertTrue(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0)), 0.95));
        assertFalse(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0)), 0.8));
        assertTrue(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0)), 0.1));
        assertTrue(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1)), 1.0));
        assertFalse(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1)), 0.5));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single-element list: no pair exists
        assertFalse(s.hasCloseElements(new ArrayList<>(List.of(1.0)), 1.0));
        // Exactly at threshold (not less than): should be false
        assertFalse(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 2.0)), 1.0));
        // Just below threshold: true
        assertTrue(s.hasCloseElements(new ArrayList<>(Arrays.asList(1.0, 1.5)), 1.0));
        // Identical elements: distance 0 is always < any positive threshold
        assertTrue(s.hasCloseElements(new ArrayList<>(Arrays.asList(5.0, 5.0)), 0.1));
    }
}
